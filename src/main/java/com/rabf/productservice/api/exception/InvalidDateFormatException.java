package com.rabf.productservice.api.exception;

public class InvalidDateFormatException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 7600777392639348178L;

    public InvalidDateFormatException (String message) {
        super(message);
    }

}
