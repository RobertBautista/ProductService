package com.rabf.productservice.api.bussines.discount;

import com.rabf.productservice.api.dto.ProductDto;

public class GoldDiscount implements IDiscountStrategy {

    public static final int BASIC_LIGHT_DISCOUNT = 10;
    public static final int PLUS_PREMIUM_DISCOUNT = 5;
    private static GoldDiscount instance = null;

    private GoldDiscount () {

    }

    public static GoldDiscount getInstance() {
        if (instance == null) {
            instance = new GoldDiscount();
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
