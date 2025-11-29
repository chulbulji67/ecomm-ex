package com.ecomm.product.exception;

public class ProductNotFound extends RuntimeException {

    String msg;
    public ProductNotFound(String msg) {
        this.msg = msg;
    }
}
