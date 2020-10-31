package com.rabf.productservice.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabf.productservice.api.controller.model.product.ProductRequest;
import com.rabf.productservice.api.controller.model.product.ProductResponse;
import com.rabf.productservice.api.dto.ProductDto;
import com.rabf.productservice.api.service.IProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	IProductService productService;
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
				produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody ProductRequest product){
		ModelMapper modelMapper = new ModelMapper();
		ProductDto productDto = modelMapper.map(product, ProductDto.class);
		ProductDto productDtoResponse = productService.createProduct(productDto);
		ProductResponse productResponse = modelMapper.map(productDtoResponse, ProductResponse.class);
		return new ResponseEntity<>(productResponse, HttpStatus.CREATED);
	}

	@GetMapping(path = {"/{productId}"},
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ProductResponse> getProduct(@PathVariable String productId){
		ProductDto productDto = productService.getProductByProductId(productId);
		ModelMapper modelMapper = new ModelMapper();
		ProductResponse productResponse = modelMapper.map(productDto, ProductResponse.class);
		return new ResponseEntity<>(productResponse, HttpStatus.OK);
	}
	
	@GetMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<ProductResponse>> getProducts() {
		List<ProductDto> products = productService.getAllProducts();
		ModelMapper modelMapper = new ModelMapper();
		List<ProductResponse> productsResponse = products.stream().
				map(product -> modelMapper.map(product, ProductResponse.class)).
				collect(Collectors.toList());
		return new ResponseEntity<List<ProductResponse>>(productsResponse, HttpStatus.OK);
	}
	
}
