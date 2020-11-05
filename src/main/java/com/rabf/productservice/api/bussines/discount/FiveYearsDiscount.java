package com.rabf.productservice.api.bussines.discount;

import com.rabf.productservice.api.domain.Product;

public class FiveYearsDiscount implements IDiscountStrategy {

    public static final int DISCOUNT = 5;

    private static FiveYearsDiscount instance = null;

    private FiveYearsDiscount () {

    }

    public static FiveYearsDiscount getInstance() {
        if (instance == null) {
            instance = new FiveYearsDiscount();
        }

        return instance;
    }

    @Override
    public Product applyDiscount(Product product) {
        product.setDiscount(product.getDiscount() + DISCOUNT);
        return product;
    }
}
