package com.rivaldy.customer.controller;

import com.rivaldy.customer.dto.CustomerRegistrationRequest;
import com.rivaldy.customer.dto.CustomerResponse;
import com.rivaldy.customer.service.ICustomer;
import com.rivaldy.customer.util.DataMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
@Slf4j
public class CustomerController {

    private final ICustomer service;
    private final DataMapper mapper;

    @PostMapping
    public ResponseEntity registerCustomer(@Valid @RequestBody CustomerRegistrationRequest request){
      log.info("create new customer {}", request);
      return ResponseEntity.status(HttpStatus.CREATED)
              .body(mapper.toCustomerRes(service.registerCustomer(request)));
    }

    @GetMapping("/get/{customerId}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable("customerId") String id){
        log.info("get customer by id {}", id);
        return ResponseEntity.ok(mapper.toCustomerRes(service.getCustomer(id)));
    }

    @GetMapping
    public ResponseEntity<?> getAllCustomer(){
        log.info("get all customer");
        return ResponseEntity.ok(mapper.toCustomerListRes(service.getAllCustomers()));
    }
}
