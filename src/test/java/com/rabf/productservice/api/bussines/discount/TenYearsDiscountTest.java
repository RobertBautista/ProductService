package com.rabf.productservice.api.bussines.discount;

import com.rabf.productservice.api.domain.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TenYearsDiscountTest {

    @Test
    public void productDiscountIsIncrementedBy10 () {
        float oldDiscount = 10;
        Product product = Product.builder().
                discount(oldDiscount).
                build();

        Product resp = TenYearsDiscount.getInstance().applyDiscount(product);
        Assertions.assertEquals(oldDiscount + TenYearsDiscount.DISCOUNT, resp.getDiscount());
    }

}
