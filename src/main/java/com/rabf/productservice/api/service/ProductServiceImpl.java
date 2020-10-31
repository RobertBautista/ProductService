package com.rabf.productservice.api.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rabf.productservice.api.dto.ProductDto;
import com.rabf.productservice.api.exception.ProductNotFoundException;
import com.rabf.productservice.api.product.data.ProductEntity;
import com.rabf.productservice.api.product.data.ProductRepository;
import com.rabf.productservice.api.utils.ProductUtils;

@Service
public class ProductServiceImpl implements IProductService {

	ProductUtils productUtils;
	
	ProductRepository productRepository;
	
	Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Autowired
	public ProductServiceImpl(ProductUtils productUtils, ProductRepository productRepository) {
		super();
		this.productUtils = productUtils;
		this.productRepository = productRepository;
	}

	@Override
	public List<ProductDto> getAllProducts() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	
		Iterable<ProductEntity> productsEntity = productRepository.findAll();
		List<ProductDto> result = new ArrayList<>();
		productsEntity.forEach(x -> result.add(modelMapper.map(x, ProductDto.class)));
		return result;
	}

	@Override
	public ProductDto createProduct(ProductDto productDto) {
		productDto.setProductId(productUtils.getNewProductId());
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		ProductEntity entity = modelMapper.map(productDto, ProductEntity.class);
		ProductEntity newEntity = productRepository.save(entity);
		return modelMapper.map(newEntity, ProductDto.class);
	}

	@Override
	public ProductDto getProductByProductId(String productId) {
		ProductEntity productEntity = productRepository.findByProductId(productId);

		if (productEntity == null) {
			logger.info("User not found by id " + productId);
			throw new ProductNotFoundException("Product not found");
		}

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		return modelMapper.map(productEntity, ProductDto.class);
	}

}
