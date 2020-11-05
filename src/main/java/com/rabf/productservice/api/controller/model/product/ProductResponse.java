package com.rabf.productservice.api.controller.model.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductResponse {

	private String productId;
	
	private String name;
	
	private String mark;

	private String category;

	private float discount;
	
}
