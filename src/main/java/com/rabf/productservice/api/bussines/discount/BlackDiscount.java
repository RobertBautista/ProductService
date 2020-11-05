package com.rabf.productservice.api.bussines.discount;

import com.rabf.productservice.api.dto.ProductDto;

public class BlackDiscount implements IDiscountStrategy {

    public static final int BASIC_LIGHT_DISCOUNT = 30;
    public static final int PLUS_PREMIUM_DISCOUNT = 15;

    private static BlackDiscount instance = null;

    private BlackDiscount () {

    }

    public static BlackDiscount getInstance() {
        if (instance == null) {
            instance = new BlackDiscount();
        }

        return instance;
    }

    @Override
    public ProductDto applyDiscount(ProductDto productDto) {
        switch (productDto.getCategory().getProductCategory()) {
            case BASIC:
            case LIGHT:
                productDto.setDiscount(productDto.getDiscount() + BASIC_LIGHT_DISCOUNT);
                break;
            case PLUS:
            case PREMIUM:
                productDto.setDiscount(productDto.getDiscount() + PLUS_PREMIUM_DISCOUNT);
                break;
        }

        return productDto;
    }
}
