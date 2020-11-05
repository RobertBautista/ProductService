package com.rabf.productservice.api.controller;

import com.rabf.productservice.api.controller.model.ClientRequestMapper;
import com.rabf.productservice.api.controller.model.ProductRequestMapper;
import com.rabf.productservice.api.controller.model.ProductResponseMapper;
import com.rabf.productservice.api.controller.model.client.ClientRequest;
import com.rabf.productservice.api.controller.model.product.ProductRequest;
import com.rabf.productservice.api.controller.model.product.ProductResponse;
import com.rabf.productservice.api.dto.ClientDto;
import com.rabf.productservice.api.dto.ProductDto;
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
	public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody ProductRequest product){
		ProductRequestMapper productRequestMapper = new ProductRequestMapper();
		ProductDto productDto = productRequestMapper.map(product);
		ProductDto productDtoResponse = productService.createProduct(productDto);
		ProductResponseMapper productResponseMapper = new ProductResponseMapper();
		ProductResponse productResponse = productResponseMapper.map(productDtoResponse);
		return new ResponseEntity<>(productResponse, HttpStatus.CREATED);
	}

	@GetMapping(path = {"/{productId}"},
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ProductResponse> getProduct(@PathVariable String productId){
		ProductDto productDto = productService.getProductByProductId(productId);
		ProductResponseMapper productResponseMapper = new ProductResponseMapper();
		ProductResponse productResponse = productResponseMapper.map(productDto);
		return new ResponseEntity<>(productResponse, HttpStatus.OK);
	}
	
	@GetMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<ProductResponse>> getProducts(@Valid @RequestBody ClientRequest client) {
		ClientRequestMapper clientRequestMapper = new ClientRequestMapper();
		ClientDto clientDto = clientRequestMapper.map(client);
		List<ProductDto> products = productService.getProductsByClient(clientDto);

		ProductResponseMapper productResponseMapper = new ProductResponseMapper();
		List<ProductResponse> productsResponse = products.stream().
				map(product -> productResponseMapper.map(product)).
				collect(Collectors.toList());
		return new ResponseEntity<>(productsResponse, HttpStatus.OK);
	}
	
}
