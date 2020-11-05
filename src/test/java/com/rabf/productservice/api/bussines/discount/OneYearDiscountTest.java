package com.rabf.productservice.api.bussines.discount;

import com.rabf.productservice.api.dto.ProductDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OneYearDiscountTest {

    @Test
    public void productDiscountIsIncrementedBy1 () {
        float oldDiscount = 10;
        ProductDto productDto = ProductDto.builder().
                discount(oldDiscount).
                build();

        ProductDto resp = OneYearDiscount.getInstance().applyDiscount(productDto);
        Assertions.assertEquals(oldDiscount + OneYearDiscount.DISCOUNT, resp.getDiscount());
    }

}
