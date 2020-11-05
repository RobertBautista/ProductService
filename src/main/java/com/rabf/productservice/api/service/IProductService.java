package com.rabf.productservice.api.service;

import java.util.List;

import com.rabf.productservice.api.domain.Client;
import com.rabf.productservice.api.domain.Product;

public interface IProductService {

	// List<ProductDto> getAllProducts();

	Product createProduct(Product product);

	Product getProductByProductId(String productId);

	List<Product> getProductsByClient(Client client);
}
