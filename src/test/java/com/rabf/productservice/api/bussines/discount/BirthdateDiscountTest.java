package com.rabf.productservice.api.bussines.discount;

import com.rabf.productservice.api.domain.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BirthdateDiscountTest {

    @Test
    public void whenProductDiscountIsAddedToBirthdayDiscountAndIsSmallerThan35_thenDiscountIsIncrementedBy10 () {
        float oldDiscount = 10;
        Product product = Product.builder().
                discount(oldDiscount).
                build();

        product = BirthdateDiscount.getInstance().applyDiscount(product);
        Assertions.assertEquals(oldDiscount + BirthdateDiscount.DISCOUNT, product.getDiscount());
    }

    @Test
    public void whenProductDiscountIsAddedToBirthdayDiscountAndIsGreaterThan35_thenDiscountIsNotIncremented () {
        float oldDiscount = 26;
        Product product = Product.builder().
                discount(oldDiscount).
                build();

        product = BirthdateDiscount.getInstance().applyDiscount(product);

        Assertions.assertEquals(oldDiscount, product.getDiscount());
    }
}
