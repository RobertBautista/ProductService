package com.rabf.productservice.api.bussines.discount;

import com.rabf.productservice.api.domain.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FiveYearsDiscountTest {

    @Test
    public void productDiscountIsIncrementedBy5 () {
        float oldDiscount = 10;
        Product product = Product.builder().
                discount(oldDiscount).
                build();

        Product resp = FiveYearsDiscount.getInstance().applyDiscount(product);
        Assertions.assertEquals(oldDiscount + FiveYearsDiscount.DISCOUNT, resp.getDiscount());
    }
}
