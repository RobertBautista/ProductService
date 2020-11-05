package com.rabf.productservice.api.service;

import java.util.List;

import com.rabf.productservice.api.domain.dto.ClientDto;
import com.rabf.productservice.api.domain.dto.ProductDto;

public interface IProductService {

	// List<ProductDto> getAllProducts();

	ProductDto createProduct(ProductDto productDto);

	ProductDto getProductByProductId(String productId);

	List<ProductDto> getProductsByClient(ClientDto client);
}
