package com.rabf.productservice.api.bussines.discount;

import com.rabf.productservice.api.domain.dto.ProductDto;

public interface IDiscountStrategy {

    ProductDto applyDiscount(ProductDto productDto);

}
