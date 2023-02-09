package com.rivaldy.order.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderRequest {

    private String customerId;
    private String productId;
    private int qty;
}
