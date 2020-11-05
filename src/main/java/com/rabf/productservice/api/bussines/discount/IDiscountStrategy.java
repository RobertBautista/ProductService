package com.rabf.productservice.api.bussines.discount;

import com.rabf.productservice.api.domain.Product;

public interface IDiscountStrategy {

    Product applyDiscount(Product product);

}
