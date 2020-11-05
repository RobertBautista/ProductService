package com.rabf.productservice.api.controller.handlerexception;

import com.rabf.productservice.api.exception.InvalidClientCategoryException;
import com.rabf.productservice.api.exception.InvalidDateFormatException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.rabf.productservice.api.exception.ProductNotFoundException;

@ControllerAdvice
public class ProductHandlerException {

	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<Object> handleException(Exception ex, WebRequest request) {
		String message = "Undefined error: " + loadDetail(ex);
		return new ResponseEntity<>(message, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = {ProductNotFoundException.class})
	public ResponseEntity<Object> handleProductServiceException(Exception ex, WebRequest request) {
		String message = "Problems loading user with id: " + loadDetail(ex);
		return new ResponseEntity<>(message, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = {InvalidDateFormatException.class})
	public ResponseEntity<Object> handleDateFormatException(Exception ex, WebRequest request) {
		String message = "Invalid date format in client data: " + loadDetail(ex);
		return new ResponseEntity<>(message, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = {InvalidClientCategoryException.class})
	public ResponseEntity<Object> handleClientCategoryException(Exception ex, WebRequest request) {
		String message = "Invalid category in client data: " + loadDetail(ex);
		return new ResponseEntity<>(message, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	private String loadDetail(Exception ex) {
		String detail = ex.getLocalizedMessage(); 
		if (detail == null) {
			detail = ex.toString();
		}
		
		return detail;
	}
	
}
