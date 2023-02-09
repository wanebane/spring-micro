package com.rivaldy.clients.product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "${product.name}", url = "${product.url}")
public interface ProductClient {

    @GetMapping(path = "/get/{productId}")
    ProductResponse fetchProductByProductId(@PathVariable("productId") String productId);
}
