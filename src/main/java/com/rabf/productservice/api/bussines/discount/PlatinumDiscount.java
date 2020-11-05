package com.rabf.productservice.api.bussines.discount;

import com.rabf.productservice.api.domain.dto.ProductDto;

public class PlatinumDiscount implements IDiscountStrategy {

    public static final int BASIC_LIGHT_DISCOUNT = 20;
    public static final int PLUS_PREMIUM_DISCOUNT = 10;
    private static PlatinumDiscount instance = null;

    private PlatinumDiscount () {

    }

    public static PlatinumDiscount getInstance() {
        if (instance == null) {
            instance = new PlatinumDiscount();
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
