package com.rivaldy.product.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseFieldInvalid {

    private String code;
    private String solution;
    private Object description;
}
