package com.rabf.productservice.api.bussines.discount;

import com.rabf.productservice.api.domain.Category;
import com.rabf.productservice.api.domain.Product;
import com.rabf.productservice.api.enums.EProductCategory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GoldDiscountTest {

    @Test
    public void whenProductIsBasicCategory_thenDiscountIsIncrementedBy10() {
        float oldDiscount = 10;
        Product product = Product.builder().
                discount(oldDiscount).
                category(Category.builder().
                        name(EProductCategory.BASIC.toString()).build()
                ).build();
        Product resp = GoldDiscount.getInstance().applyDiscount(product);
        Assertions.assertEquals(oldDiscount + GoldDiscount.BASIC_LIGHT_DISCOUNT, resp.getDiscount());
    }

    @Test
    public void whenProductIsLightCategory_thenDiscountIsIncrementedBy10() {
        float oldDiscount = 11;
        Product product = Product.builder().
                discount(oldDiscount).
                category(Category.builder().
                        name(EProductCategory.LIGHT.toString()).build()
                ).build();
        Product resp = GoldDiscount.getInstance().applyDiscount(product);
        Assertions.assertEquals(oldDiscount + GoldDiscount.BASIC_LIGHT_DISCOUNT, resp.getDiscount());
    }

    @Test
    public void whenProductIsPlusCategory_thenDiscountIsIncrementedBy5() {
        float oldDiscount = 10;
        Product product = Product.builder().
                discount(oldDiscount).
                category(Category.builder().
                        name(EProductCategory.PLUS.toString()).build()
                ).build();
        Product resp = GoldDiscount.getInstance().applyDiscount(product);
        Assertions.assertEquals(oldDiscount + GoldDiscount.PLUS_PREMIUM_DISCOUNT, resp.getDiscount());
    }

    @Test
    public void whenProductIsPremiumCategory_thenDiscountIsIncrementedBy5() {
        float oldDiscount = 11;
        Product product = Product.builder().
                discount(oldDiscount).
                category(Category.builder().
                        name(EProductCategory.PREMIUM.toString()).build()
                ).build();
        Product resp = GoldDiscount.getInstance().applyDiscount(product);
        Assertions.assertEquals(oldDiscount + GoldDiscount.PLUS_PREMIUM_DISCOUNT, resp.getDiscount());
    }

}
