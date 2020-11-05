package com.rabf.productservice.api.bussines.discount;

import com.rabf.productservice.api.domain.Product;

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
    public Product applyDiscount(Product product) {
        switch (product.getCategory().getProductCategory()) {
            case BASIC:
            case LIGHT:
                product.setDiscount(product.getDiscount() + BASIC_LIGHT_DISCOUNT);
                break;
            case PLUS:
            case PREMIUM:
                product.setDiscount(product.getDiscount() + PLUS_PREMIUM_DISCOUNT);
                break;
        }

        return product;
    }
}
