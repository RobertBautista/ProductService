package com.rabf.productservice.api.controller.model.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class ProductResponseDto implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -1377253643777389196L;

	private String productId;
	
	private String name;
	
	private String mark;

	private String category;

	private float discount;
	
}
