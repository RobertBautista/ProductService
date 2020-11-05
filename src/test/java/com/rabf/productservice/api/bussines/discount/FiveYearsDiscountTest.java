package com.rabf.productservice.api.bussines.discount;

import com.rabf.productservice.api.dto.ProductDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FiveYearsDiscountTest {

    @Test
    public void productDiscountIsIncrementedBy5 () {
        float oldDiscount = 10;
        ProductDto productDto = ProductDto.builder().
                discount(oldDiscount).
                build();

        ProductDto resp = FiveYearsDiscount.getInstance().applyDiscount(productDto);
        Assertions.assertEquals(oldDiscount + FiveYearsDiscount.DISCOUNT, resp.getDiscount());
    }
}
