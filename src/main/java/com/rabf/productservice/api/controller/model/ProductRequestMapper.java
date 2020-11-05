package com.rabf.productservice.api.controller.model;

import com.rabf.productservice.api.controller.model.product.ProductRequest;
import com.rabf.productservice.api.domain.dto.CategoryDto;
import com.rabf.productservice.api.domain.dto.ProductDto;
import com.rabf.productservice.api.enums.EProductCategory;
import org.modelmapper.ModelMapper;

public class ProductRequestMapper {

    public ProductRequestMapper() {
    }

    public ProductDto map(ProductRequest product) {
        ModelMapper modelMapper = new ModelMapper();
        ProductDto response = modelMapper.map(product, ProductDto.class);
        EProductCategory category = EProductCategory.valueOf(product.getCategory());
        response.setCategory(CategoryDto.builder().id(category.getId()).name(category.toString()).build());
        return response;
    }

}
