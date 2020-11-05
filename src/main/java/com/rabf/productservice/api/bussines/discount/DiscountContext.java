package com.rabf.productservice.api.bussines.discount;

import com.rabf.productservice.api.domain.dto.ProductDto;

import java.util.ArrayList;
import java.util.List;

public class DiscountContext {

    private final List<IDiscountStrategy> discountStrategies;

    public DiscountContext() {
        this.discountStrategies = new ArrayList<>();
    }

    public void addStrategy (IDiscountStrategy discountStrategy) {
        this.discountStrategies.add(discountStrategy);
    }

    public void executeStrategy(ProductDto productDto) {
        for(IDiscountStrategy discountStrategy : this.discountStrategies) {
            discountStrategy.applyDiscount(productDto);
        }

    }
}
