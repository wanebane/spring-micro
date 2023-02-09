package com.rivaldy.product.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseError {
    private String status;
    private String message;
    private String reason;
}
