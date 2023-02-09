package com.rivaldy.order.service;

import com.rivaldy.clients.customer.CustomerClient;
import com.rivaldy.clients.customer.CustomerResponse;
import com.rivaldy.clients.product.ProductClient;
import com.rivaldy.clients.product.ProductResponse;
import com.rivaldy.order.dto.OrderRequest;
import com.rivaldy.order.dto.OrderResponse;
import com.rivaldy.order.entity.Order;
import com.rivaldy.order.repository.OrderRepository;
import com.rivaldy.order.util.DataMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class OrderServiceImpl implements IOrder{

    private final OrderRepository repository;
    private final CustomerClient customerClient;
    private final ProductClient productClient;

    private final DataMapper mapper;

    @Override
    public OrderResponse createOrder(OrderRequest request) {
        log.info("hit endpoint customer-service : "+customerClient
                .fetchCustomerByCustomerId(request.getCustomerId()));

        CustomerResponse customerRes = customerClient.fetchCustomerByCustomerId(request.getCustomerId());

        //check product -> hit product-service
        ProductResponse productRes = productClient.fetchProductByProductId(request.getProductId());

        Order order = Order.builder()
                .customerId(Long.valueOf(request.getCustomerId()))
                .productId(Long.valueOf(request.getProductId()))
                .quantity(request.getQty())
                .totalPrice(productRes.getPrice().multiply(BigDecimal.valueOf(request.getQty())))
                .createdAt(LocalDateTime.now())
                .build();

        repository.save(order);
        return mapper.toOrderRes(order, customerRes, productRes);
    }
}
