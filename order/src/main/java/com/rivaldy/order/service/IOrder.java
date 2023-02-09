package com.rivaldy.order.service;

import com.rivaldy.order.dto.OrderRequest;
import com.rivaldy.order.dto.OrderResponse;
import com.rivaldy.order.entity.Order;

public interface IOrder {

    OrderResponse createOrder(OrderRequest request);
}
