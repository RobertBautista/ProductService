package com.rabf.productservice.api.bussines.discount;

import com.rabf.productservice.api.dto.ProductDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BirthdateDiscountTest {

    @Test
    public void whenProductDiscountIsAddedToBirthdayDiscountAndIsSmallerThan35_thenDiscountIsIncrementedBy10 () {
        float oldDiscount = 10;
        ProductDto productDto = ProductDto.builder().
                discount(oldDiscount).
                build();

        productDto = BirthdateDiscount.getInstance().applyDiscount(productDto);
        Assertions.assertEquals(oldDiscount + BirthdateDiscount.DISCOUNT, productDto.getDiscount());
    }

    @Test
    public void whenProductDiscountIsAddedToBirthdayDiscountAndIsGreaterThan35_thenDiscountIsNotIncremented () {
        float oldDiscount = 26;
        ProductDto productDto = ProductDto.builder().
                discount(oldDiscount).
                build();

        productDto = BirthdateDiscount.getInstance().applyDiscount(productDto);

        Assertions.assertEquals(oldDiscount, productDto.getDiscount());
    }
}
