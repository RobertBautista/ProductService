package com.rabf.productservice.api.exception;

public class InvalidClientCategoryException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 7600777392639348179L;

    public InvalidClientCategoryException (String message) {
        super(message);
    }
}
