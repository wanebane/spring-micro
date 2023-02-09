package com.rivaldy.customer.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerAlreadyExistsException extends RuntimeException{

    private String message;
    public CustomerAlreadyExistsException(String message, Throwable cause, boolean enableSuppresion, boolean writableStackTrace){
        super(message, cause, enableSuppresion, writableStackTrace);
        this.message = message;
    }
}
