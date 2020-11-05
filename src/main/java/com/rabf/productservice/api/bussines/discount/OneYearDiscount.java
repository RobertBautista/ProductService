package com.rabf.productservice.api.bussines.discount;

import com.rabf.productservice.api.domain.Product;

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
    public Product applyDiscount(Product product) {
        product.setDiscount(product.getDiscount() + DISCOUNT);
        return product;
    }

}
