package com.rabf.productservice.api.controller.model.product;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {

	@NotNull(message="Name cannot be null")
	@Size(min=5, max=20, message="Name must have more than 4 characters and less than 21 ")
	private String name;

	@NotNull(message="Mark cannot be null")
	@Size(min=5, max=20, message="Mark must have more than 4 characters and less than 21 ")
	private String mark;

	@NotNull(message="Category cannot be null")
	private String category;
	
}
