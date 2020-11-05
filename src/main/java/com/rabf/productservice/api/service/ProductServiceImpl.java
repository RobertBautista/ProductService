package com.rabf.productservice.api.service;

import java.util.ArrayList;
import java.util.List;

import com.rabf.productservice.api.bussines.IDiscountService;
import com.rabf.productservice.api.domain.Client;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rabf.productservice.api.domain.Product;
import com.rabf.productservice.api.exception.ProductNotFoundException;
import com.rabf.productservice.api.product.data.ProductEntity;
import com.rabf.productservice.api.product.data.ProductRepository;
import com.rabf.productservice.api.utils.ProductUtils;

@Service
public class ProductServiceImpl implements IProductService {

	ProductUtils productUtils;

	IDiscountService discountService;

	ProductRepository productRepository;
	
	Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Autowired
	public ProductServiceImpl(ProductUtils productUtils, ProductRepository productRepository,
							  IDiscountService discountService) {
		super();
		this.productUtils = productUtils;
		this.productRepository = productRepository;
		this.discountService = discountService;
	}

	private List<Product> getAllProducts() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	
		Iterable<ProductEntity> productsEntity = productRepository.findAll();
		List<Product> result = new ArrayList<>();
		productsEntity.forEach(x -> result.add(modelMapper.map(x, Product.class)));
		return result;
	}

	@Override
	public Product createProduct(Product product) {
		product.setProductId(productUtils.getNewProductId());
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		ProductEntity entity = modelMapper.map(product, ProductEntity.class);
		ProductEntity newEntity = productRepository.save(entity);
		return modelMapper.map(newEntity, Product.class);
	}

	@Override
	public Product getProductByProductId(String productId) {
		ProductEntity productEntity = productRepository.findByProductId(productId);

		if (productEntity == null) {
			logger.info("User not found by id " + productId);
			throw new ProductNotFoundException("Product not found");
		}

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		return modelMapper.map(productEntity, Product.class);
	}

	@Override
	public List<Product> getProductsByClient(Client client) {
		List<Product> products = getAllProducts();
		return discountService.getDiscountsByClientCategory(client, products);
	}

}
