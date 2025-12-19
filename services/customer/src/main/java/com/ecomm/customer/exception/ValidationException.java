package com.ecomm.customer.exception;

import org.springframework.validation.annotation.Validated;

public class ValidationException extends RuntimeException {
    public ValidationException(String msg){
        super(msg);
    }
}
