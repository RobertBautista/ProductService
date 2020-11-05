package com.rabf.productservice.api.bussines.discount;

import com.rabf.productservice.api.domain.Product;

public class BirthdateDiscount implements IDiscountStrategy {

    public final static float DISCOUNT = 10;

    public final static float MAX_DISCOUNT = 35;

    private static BirthdateDiscount instance = null;

    private BirthdateDiscount () {

    }

    public static BirthdateDiscount getInstance() {
        if (instance == null) {
            instance = new BirthdateDiscount();
        }

        return instance;
    }

    @Override
    public Product applyDiscount(Product product) {
        if (product.getDiscount() + DISCOUNT <= MAX_DISCOUNT) {
            product.setDiscount(product.getDiscount() + DISCOUNT);
        }

        return product;
    }

}
