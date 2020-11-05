package com.rabf.productservice.api.bussines.discount;

import com.rabf.productservice.api.domain.dto.ProductDto;

public class OneYearDiscount implements IDiscountStrategy {

    public static final int DISCOUNT = 1;
    private static OneYearDiscount instance = null;

    private OneYearDiscount () {

    }

    public static OneYearDiscount getInstance() {
        if (instance == null) {
            instance = new OneYearDiscount();
        }

        return instance;
    }

    @Override
    public ProductDto applyDiscount(ProductDto productDto) {
        productDto.setDiscount(productDto.getDiscount() + DISCOUNT);
        return productDto;
    }

}
