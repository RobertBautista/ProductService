package com.rabf.productservice.api.service;

import com.rabf.productservice.api.bussines.DiscountServiceImpl;
import com.rabf.productservice.api.bussines.discount.*;
import com.rabf.productservice.api.dto.ClientDto;
import com.rabf.productservice.api.dto.ProductDto;
import com.rabf.productservice.api.enums.EClientCategory;
import com.rabf.productservice.api.product.data.CategoryEntity;
import com.rabf.productservice.api.product.data.ProductEntity;
import com.rabf.productservice.api.product.data.ProductRepository;
import com.rabf.productservice.api.utils.ProductUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    private IProductService productService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        productService = new ProductServiceImpl(new ProductUtils(), productRepository, new DiscountServiceImpl());
        List<ProductEntity> productEntities = new ArrayList<>();
        productEntities.add(ProductEntity.builder().
                name("Product 1").
                productId("prod-01x1").
                mark("Any mark 1").
                category(CategoryEntity.builder().
                        id(1L).
                        name("BASIC").
                        build()).
                build());
        productEntities.add(ProductEntity.builder().
                name("Product 2").
                productId("prod-02x2").
                mark("Any mark 1").
                category(CategoryEntity.builder().
                        id(2L).
                        name("LIGHT").
                        build()).
                build());
        productEntities.add(ProductEntity.builder().
                name("Product 3").
                productId("prod-03x3").
                mark("Any mark 2").
                category(CategoryEntity.builder().
                        id(3L).
                        name("PLUS").
                        build()).
                build());
        productEntities.add(ProductEntity.builder().
                name("Product 4").
                productId("prod-44x4").
                mark("Any mark 2").
                category(CategoryEntity.builder().
                        id(4L).
                        name("PREMIUM").
                        build()).
                build());
        Mockito.when(productRepository.findAll()).thenReturn(productEntities);
    }

    private ClientDto getClientDto(EClientCategory category, Calendar birthCal, Calendar memberSinceCal) {
        return ClientDto.builder().
                firstname("Juan").
                lastname("Perez").
                memberSince(memberSinceCal.getTime()).
                birthdate(birthCal.getTime()).
                category(category).
                build();
    }

    @Test
    public void whenClientIsGoldApplyDiscountForAllProductTypesWithOneYearOfMemberAndIsNotBirthdate() {
        Calendar birthCal = Calendar.getInstance();
        birthCal.set(Calendar.YEAR, birthCal.get(Calendar.YEAR) - 40);
        birthCal.set(Calendar.MONTH, birthCal.get(Calendar.MONTH) - 1);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) - 2);

        List<ProductDto> response = productService.getProductsByClient(getClientDto(EClientCategory.GOLD, birthCal,
                cal));

        Assertions.assertThat(response.size()).isEqualTo(4);
        org.junit.jupiter.api.Assertions.assertEquals(GoldDiscount.BASIC_LIGHT_DISCOUNT +
                OneYearDiscount.DISCOUNT, response.get(0).getDiscount());
        org.junit.jupiter.api.Assertions.assertEquals(GoldDiscount.BASIC_LIGHT_DISCOUNT +
                OneYearDiscount.DISCOUNT, response.get(1).getDiscount());
        org.junit.jupiter.api.Assertions.assertEquals(GoldDiscount.PLUS_PREMIUM_DISCOUNT +
                OneYearDiscount.DISCOUNT, response.get(2).getDiscount());
        org.junit.jupiter.api.Assertions.assertEquals(GoldDiscount.PLUS_PREMIUM_DISCOUNT +
                OneYearDiscount.DISCOUNT, response.get(3).getDiscount());
    }

    @Test
    public void whenClientIsPlatinumApplyDiscountForAllProductTypesWithFiveYearsOfMemberAndIsNotBirthdate() {
        Calendar birthCal = Calendar.getInstance();
        birthCal.set(Calendar.YEAR, birthCal.get(Calendar.YEAR) - 40);
        birthCal.set(Calendar.MONTH, birthCal.get(Calendar.MONTH) - 1);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) - 6);

        List<ProductDto> response = productService.getProductsByClient(getClientDto(EClientCategory.PLATINUM, birthCal,
                cal));

        Assertions.assertThat(response.size()).isEqualTo(4);
        org.junit.jupiter.api.Assertions.assertEquals(PlatinumDiscount.BASIC_LIGHT_DISCOUNT +
                FiveYearsDiscount.DISCOUNT, response.get(0).getDiscount());
        org.junit.jupiter.api.Assertions.assertEquals(PlatinumDiscount.BASIC_LIGHT_DISCOUNT +
                FiveYearsDiscount.DISCOUNT, response.get(1).getDiscount());
        org.junit.jupiter.api.Assertions.assertEquals(PlatinumDiscount.PLUS_PREMIUM_DISCOUNT +
                FiveYearsDiscount.DISCOUNT, response.get(2).getDiscount());
        org.junit.jupiter.api.Assertions.assertEquals(PlatinumDiscount.PLUS_PREMIUM_DISCOUNT +
                FiveYearsDiscount.DISCOUNT, response.get(3).getDiscount());
    }

    @Test
    public void whenClientIsBlackApplyDiscountForAllProductTypesWithTenYearsOfMemberAndIsNotBirthdate() {
        Calendar birthCal = Calendar.getInstance();
        birthCal.set(Calendar.YEAR, birthCal.get(Calendar.YEAR) - 40);
        birthCal.set(Calendar.MONTH, birthCal.get(Calendar.MONTH) - 1);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) - 11);

        List<ProductDto> response = productService.getProductsByClient(getClientDto(EClientCategory.BLACK, birthCal,
                cal));

        Assertions.assertThat(response.size()).isEqualTo(4);
        org.junit.jupiter.api.Assertions.assertEquals(BlackDiscount.BASIC_LIGHT_DISCOUNT +
                TenYearsDiscount.DISCOUNT, response.get(0).getDiscount());
        org.junit.jupiter.api.Assertions.assertEquals(BlackDiscount.BASIC_LIGHT_DISCOUNT +
                TenYearsDiscount.DISCOUNT, response.get(1).getDiscount());
        org.junit.jupiter.api.Assertions.assertEquals(BlackDiscount.PLUS_PREMIUM_DISCOUNT +
                TenYearsDiscount.DISCOUNT, response.get(2).getDiscount());
        org.junit.jupiter.api.Assertions.assertEquals(BlackDiscount.PLUS_PREMIUM_DISCOUNT +
                TenYearsDiscount.DISCOUNT, response.get(3).getDiscount());
    }

    @Test
    public void whenClientIsPlatinumApplyDiscountForAllProductTypesWithTenYearsOfMemberAndIsBirthdate() {
        Calendar birthCal = Calendar.getInstance();
        birthCal.set(Calendar.YEAR, birthCal.get(Calendar.YEAR) - 40);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) - 11);

        List<ProductDto> response = productService.getProductsByClient(getClientDto(EClientCategory.PLATINUM, birthCal,
                cal));

        Assertions.assertThat(response.size()).isEqualTo(4);
        org.junit.jupiter.api.Assertions.assertEquals(PlatinumDiscount.BASIC_LIGHT_DISCOUNT +
                TenYearsDiscount.DISCOUNT, response.get(0).getDiscount());
        org.junit.jupiter.api.Assertions.assertEquals(PlatinumDiscount.BASIC_LIGHT_DISCOUNT +
                TenYearsDiscount.DISCOUNT, response.get(1).getDiscount());
        org.junit.jupiter.api.Assertions.assertEquals(PlatinumDiscount.PLUS_PREMIUM_DISCOUNT +
                TenYearsDiscount.DISCOUNT + BirthdateDiscount.DISCOUNT, response.get(2).getDiscount());
        org.junit.jupiter.api.Assertions.assertEquals(PlatinumDiscount.PLUS_PREMIUM_DISCOUNT +
                TenYearsDiscount.DISCOUNT + BirthdateDiscount.DISCOUNT, response.get(3).getDiscount());
    }

}
