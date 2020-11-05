package com.rabf.productservice.api.controller.model;

import com.rabf.productservice.api.controller.model.product.ProductRequestDto;
import com.rabf.productservice.api.domain.Category;
import com.rabf.productservice.api.domain.Product;
import com.rabf.productservice.api.enums.EProductCategory;
import org.modelmapper.ModelMapper;

public class ProductRequestMapper {

    public ProductRequestMapper() {
    }

    public Product map(ProductRequestDto product) {
        ModelMapper modelMapper = new ModelMapper();
        Product response = modelMapper.map(product, Product.class);
        EProductCategory category = EProductCategory.valueOf(product.getCategory());
        response.setCategory(Category.builder().id(category.getId()).name(category.toString()).build());
        return response;
    }

}
