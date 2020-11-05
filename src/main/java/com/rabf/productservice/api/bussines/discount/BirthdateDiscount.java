package com.rabf.productservice.api.bussines.discount;

import com.rabf.productservice.api.domain.dto.ProductDto;

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
    public ProductDto applyDiscount(ProductDto productDto) {
        if (productDto.getDiscount() + DISCOUNT <= MAX_DISCOUNT) {
            productDto.setDiscount(productDto.getDiscount() + DISCOUNT);
        }

        return productDto;
    }

}
