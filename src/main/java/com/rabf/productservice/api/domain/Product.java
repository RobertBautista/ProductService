package com.rabf.productservice.api.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -1377253643777389185L;

	private String productId;
	
	private String name;
	
	private String mark;

	private Category category;

	private float discount;

}