package com.rivaldy.clients.customer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "${customer.name}", url="${customer.url}")
public interface CustomerClient {

    @GetMapping(path = "/get/{customerId}")
    CustomerResponse fetchCustomerByCustomerId(@PathVariable("customerId") String customerId);
}
