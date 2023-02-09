package com.rivaldy.product.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddProductRequest {
    private String name;
    private String description;
    private String price;
}
