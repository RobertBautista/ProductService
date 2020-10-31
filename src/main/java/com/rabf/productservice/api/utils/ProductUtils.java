package com.rabf.productservice.api.utils;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class ProductUtils {

	public String getNewProductId() {
		return UUID.randomUUID().toString();
	}
	
}
