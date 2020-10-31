package com.rabf.productservice.api.exception;

public class ProductNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7600777392639348177L;

	public ProductNotFoundException (String message) {
		super(message);
	}
}
