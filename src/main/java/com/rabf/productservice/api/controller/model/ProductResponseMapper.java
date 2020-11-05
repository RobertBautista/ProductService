package com.rabf.productservice.api.controller.model;

import com.rabf.productservice.api.controller.model.product.ProductResponseDto;
import com.rabf.productservice.api.domain.Product;
import org.modelmapper.ModelMapper;

public class ProductResponseMapper {

    public ProductResponseMapper() {
    }

    public ProductResponseDto map(Product product) {
        ModelMapper modelMapper = new ModelMapper();
        ProductResponseDto response = modelMapper.map(product, ProductResponseDto.class);
        response.setCategory(product.getCategory().getName());
        return response;
    }

}
