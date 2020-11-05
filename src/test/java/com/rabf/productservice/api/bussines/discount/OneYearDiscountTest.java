package com.rabf.productservice.api.bussines.discount;

import com.rabf.productservice.api.domain.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OneYearDiscountTest {

    @Test
    public void productDiscountIsIncrementedBy1 () {
        float oldDiscount = 10;
        Product product = Product.builder().
                discount(oldDiscount).
                build();

        Product resp = OneYearDiscount.getInstance().applyDiscount(product);
        Assertions.assertEquals(oldDiscount + OneYearDiscount.DISCOUNT, resp.getDiscount());
    }

}
