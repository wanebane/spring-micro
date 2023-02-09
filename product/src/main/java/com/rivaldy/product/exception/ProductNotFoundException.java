package com.rivaldy.product.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductNotFoundException extends RuntimeException{

    private String message;

    public ProductNotFoundException(String message, Throwable cause, boolean enableSuppresion, boolean writableStackTrace){
        super(message, cause, enableSuppresion, writableStackTrace);
        this.message = message;
    }
}
