package com.rabf.productservice.api.controller;

import com.rabf.productservice.api.controller.model.ClientRequestMapper;
import com.rabf.productservice.api.controller.model.ProductRequestMapper;
import com.rabf.productservice.api.controller.model.ProductResponseMapper;
import com.rabf.productservice.api.controller.model.client.ClientRequestDto;
import com.rabf.productservice.api.controller.model.product.ProductRequestDto;
import com.rabf.productservice.api.controller.model.product.ProductResponseDto;
import com.rabf.productservice.api.domain.Client;
import com.rabf.productservice.api.domain.Product;
import com.rabf.productservice.api.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	IProductService productService;
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
				produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<ProductResponseDto> createProduct(@Valid @RequestBody ProductRequestDto product){
		ProductRequestMapper productRequestMapper = new ProductRequestMapper();
		Product productDto = productRequestMapper.map(product);
		Product productResponse = productService.createProduct(productDto);
		ProductResponseMapper productResponseMapper = new ProductResponseMapper();
		ProductResponseDto productResponseDto = productResponseMapper.map(productResponse);
		return new ResponseEntity<>(productResponseDto, HttpStatus.CREATED);
	}

	@GetMapping(path = {"/{productId}"},
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ProductResponseDto> getProduct(@PathVariable String productId){
		Product product = productService.getProductByProductId(productId);
		ProductResponseMapper productResponseMapper = new ProductResponseMapper();
		ProductResponseDto productResponseDto = productResponseMapper.map(product);
		return new ResponseEntity<>(productResponseDto, HttpStatus.OK);
	}
	
	@GetMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<ProductResponseDto>> getProducts(@Valid @RequestBody ClientRequestDto client) {
		ClientRequestMapper clientRequestMapper = new ClientRequestMapper();
		Client clientDto = clientRequestMapper.map(client);
		List<Product> products = productService.getProductsByClient(clientDto);

		ProductResponseMapper productResponseMapper = new ProductResponseMapper();
		List<ProductResponseDto> productsResponse = products.stream().
				map(product -> productResponseMapper.map(product)).
				collect(Collectors.toList());
		return new ResponseEntity<>(productsResponse, HttpStatus.OK);
	}
	
}
