package com.rivaldy.product.service;

import com.rivaldy.product.dto.AddProductRequest;
import com.rivaldy.product.entity.Product;
import com.rivaldy.product.exception.ProductNotFoundException;
import com.rivaldy.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ProductServiceImpl implements IProduct{

    private final ProductRepository repository;

    @Override
    public Product addProduct(AddProductRequest request) {
        Product product = Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(BigDecimal.valueOf(Double.valueOf(request.getPrice())))
                .createdAt(LocalDateTime.now())
                .build();
        repository.save(product);
        return product;
    }

    @Override
    public Product getProduct(Long productId) {
        return repository.findProductById(productId)
                .orElseThrow(() -> new ProductNotFoundException("product "+productId+" is not found!"));
    }

    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }
}
