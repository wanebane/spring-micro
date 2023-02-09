package com.rivaldy.order.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class OrderResponse {
    private String orderId;
    private Object customer;
    private Object product;
    private int quantity;
    private BigDecimal totalPrice;
}
