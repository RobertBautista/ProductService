package com.rabf.productservice.api.bussines.discount;

import com.rabf.productservice.api.domain.Category;
import com.rabf.productservice.api.domain.Product;
import com.rabf.productservice.api.enums.EProductCategory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BlackDiscountTest {

    @Test
    public void whenProductIsBasicCategory_thenDiscountIsIncrementedBy30() {
        float oldDiscount = 10;
        Product product = Product.builder().
                discount(oldDiscount).
                category(Category.builder().
                        name(EProductCategory.BASIC.toString()).build()
                        ).build();
        Product resp = BlackDiscount.getInstance().applyDiscount(product);
        Assertions.assertEquals(oldDiscount + BlackDiscount.BASIC_LIGHT_DISCOUNT, resp.getDiscount());
    }

    @Test
    public void whenProductIsLightCategory_thenDiscountIsIncrementedBy30() {
        float oldDiscount = 11;
        Product product = Product.builder().
                discount(oldDiscount).
                category(Category.builder().
                        name(EProductCategory.LIGHT.toString()).build()
                ).build();
        Product resp = BlackDiscount.getInstance().applyDiscount(product);
        Assertions.assertEquals(oldDiscount + BlackDiscount.BASIC_LIGHT_DISCOUNT, resp.getDiscount());
    }

    @Test
    public void whenProductIsPlusCategory_thenDiscountIsIncrementedBy15() {
        float oldDiscount = 10;
        Product product = Product.builder().
                discount(oldDiscount).
                category(Category.builder().
                        name(EProductCategory.PLUS.toString()).build()
                ).build();
        Product resp = BlackDiscount.getInstance().applyDiscount(product);
        Assertions.assertEquals(oldDiscount + BlackDiscount.PLUS_PREMIUM_DISCOUNT, resp.getDiscount());
    }

    @Test
    public void whenProductIsPremiumCategory_thenDiscountIsIncrementedBy15() {
        float oldDiscount = 11;
        Product product = Product.builder().
                discount(oldDiscount).
                category(Category.builder().
                        name(EProductCategory.PREMIUM.toString()).build()
                ).build();
        Product resp = BlackDiscount.getInstance().applyDiscount(product);
        Assertions.assertEquals(oldDiscount + BlackDiscount.PLUS_PREMIUM_DISCOUNT, resp.getDiscount());
    }

}
