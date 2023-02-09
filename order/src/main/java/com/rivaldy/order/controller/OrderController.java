package com.rivaldy.order.controller;

import com.rivaldy.order.dto.OrderRequest;
import com.rivaldy.order.service.IOrder;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
@Slf4j
public class OrderController {

    private final IOrder service;

    @PostMapping
    public ResponseEntity<?> createOrder(@Valid @RequestBody OrderRequest request){
        log.info("create new order {}", request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.createOrder(request));
    }
}
