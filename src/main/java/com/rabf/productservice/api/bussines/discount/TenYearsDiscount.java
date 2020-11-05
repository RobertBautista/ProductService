package com.rabf.productservice.api.bussines.discount;

import com.rabf.productservice.api.domain.dto.ProductDto;

public class TenYearsDiscount implements IDiscountStrategy {

    public static final int DISCOUNT = 10;
    private static TenYearsDiscount instance = null;

    private TenYearsDiscount () {

    }

    public static TenYearsDiscount getInstance() {
        if (instance == null) {
            instance = new TenYearsDiscount();
        }

        return instance;
    }

    @Override
    public ProductDto applyDiscount(ProductDto productDto) {
        productDto.setDiscount(productDto.getDiscount() + DISCOUNT);
        return productDto;
    }

}
