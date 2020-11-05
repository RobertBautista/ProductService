package com.rabf.productservice.api.bussines.discount;

import com.rabf.productservice.api.domain.dto.ProductDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TenYearsDiscountTest {

    @Test
    public void productDiscountIsIncrementedBy10 () {
        float oldDiscount = 10;
        ProductDto productDto = ProductDto.builder().
                discount(oldDiscount).
                build();

        ProductDto resp = TenYearsDiscount.getInstance().applyDiscount(productDto);
        Assertions.assertEquals(oldDiscount + TenYearsDiscount.DISCOUNT, resp.getDiscount());
    }

}
