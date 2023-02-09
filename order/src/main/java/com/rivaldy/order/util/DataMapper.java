package com.rivaldy.order.util;

import com.rivaldy.clients.customer.CustomerResponse;
import com.rivaldy.clients.product.ProductResponse;
import com.rivaldy.order.dto.OrderResponse;
import com.rivaldy.order.entity.Order;
import org.springframework.stereotype.Component;

@Component
public class DataMapper {

    public OrderResponse toOrderRes(Order order, CustomerResponse customer, ProductResponse product){
        return OrderResponse.builder()
                .orderId(order.getId())
                .customer(customer)
                .product(product)
                .quantity(order.getQuantity())
                .totalPrice(order.getTotalPrice())
                .build();
    }
}
