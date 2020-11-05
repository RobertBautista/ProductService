package com.rabf.productservice.api.bussines.discount;

import com.rabf.productservice.api.dto.ProductDto;

public interface IDiscountStrategy {

    ProductDto applyDiscount(ProductDto productDto);

}
