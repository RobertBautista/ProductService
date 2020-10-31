package com.rabf.productservice.api.controller.model.product;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProductRequest {

	@NotNull(message="Name cannot be null")
	@Size(min=5, max=20, message="Name must have more than 4 characters and less than 21 ")
	private String name;

	@NotNull(message="Mark cannot be null")
	@Size(min=5, max=20, message="Mark must have more than 4 characters and less than 21 ")
	private String mark;

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
