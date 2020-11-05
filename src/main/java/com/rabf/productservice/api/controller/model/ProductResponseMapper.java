package com.rabf.productservice.api.controller.model;

import com.rabf.productservice.api.controller.model.product.ProductResponse;
import com.rabf.productservice.api.dto.ProductDto;
import org.modelmapper.ModelMapper;

public class ProductResponseMapper {

    public ProductResponseMapper() {
    }

    public ProductResponse map(ProductDto productDto) {
        ModelMapper modelMapper = new ModelMapper();
        ProductResponse response = modelMapper.map(productDto, ProductResponse.class);
        response.setCategory(productDto.getCategory().getName());
        return response;
    }

}
