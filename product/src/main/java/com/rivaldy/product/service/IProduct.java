package com.rivaldy.product.service;

import com.rivaldy.product.dto.AddProductRequest;
import com.rivaldy.product.entity.Product;

import java.util.List;

public interface IProduct {

    Product addProduct(AddProductRequest request);

    Product getProduct(Long productId);

    List<Product> getAllProducts();
}
