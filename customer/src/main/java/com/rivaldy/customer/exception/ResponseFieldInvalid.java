package com.rivaldy.customer.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ResponseFieldInvalid {

    private String code;
    private String solution;
    private Object description;
}
