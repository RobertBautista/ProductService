package com.rabf.productservice.api.bussines.discount;

import com.rabf.productservice.api.domain.Product;

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
    public Product applyDiscount(Product product) {
        product.setDiscount(product.getDiscount() + DISCOUNT);
        return product;
    }

}
