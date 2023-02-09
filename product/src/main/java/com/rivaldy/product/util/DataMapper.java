package com.rivaldy.product.util;

import com.rivaldy.product.dto.ProductResponse;
import com.rivaldy.product.entity.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class DataMapper {

    private final FormatDate formatDate;

    public ProductResponse toProductRes(Product product){
        return ProductResponse.builder()
                .id(product.getId().toString())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .createdAt(formatDate.convertLocalDateToString(product.getCreatedAt()))
                .build();
    }

    public List<ProductResponse> toProductListRes(List<Product> products){
        return products.stream()
                .map(this::toProductRes)
                .collect(Collectors.toList());
    }
}
