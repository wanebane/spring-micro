package com.rivaldy.product.controller;

import com.rivaldy.product.dto.AddProductRequest;
import com.rivaldy.product.service.IProduct;
import com.rivaldy.product.util.DataMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
@Slf4j
public class ProductController {

    private final IProduct service;
    private final DataMapper mapper;

    @PostMapping
    public ResponseEntity<?> addProduct(@Valid @RequestBody AddProductRequest request){
        log.info("create new product {}", request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mapper.toProductRes(service.addProduct(request)));
    }

    @GetMapping("/get/{productId}")
    public ResponseEntity<?> getProductById(@PathVariable("productId") Long id){
        log.info("get product by id {}", id);
        return ResponseEntity.ok(mapper.toProductRes(service.getProduct(id)));
    }

    @GetMapping
    public ResponseEntity<?> getAllProduct(){
        log.info("get all product");
        return ResponseEntity.ok(mapper.toProductListRes(service.getAllProducts()));
    }
}
