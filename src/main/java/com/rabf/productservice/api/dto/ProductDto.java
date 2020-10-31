package com.rabf.productservice.api.dto;

import java.io.Serializable;


public class ProductDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1377253643777389185L;

	private String productId;
	
	private String name;
	
	private String mark;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}
	
}