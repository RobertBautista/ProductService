package com.rabf.productservice.api.bussines;

import com.rabf.productservice.api.bussines.discount.*;
import com.rabf.productservice.api.dto.CategoryDto;
import com.rabf.productservice.api.dto.ClientDto;
import com.rabf.productservice.api.dto.ProductDto;
import com.rabf.productservice.api.enums.EClientCategory;
import com.rabf.productservice.api.enums.EProductCategory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DiscountServiceImplTest {

    private IDiscountService discountService;

    @BeforeEach
    public void init() {
        discountService = new DiscountServiceImpl();
    }

    private List<ProductDto> getProducts(EProductCategory ... categories) {
        List<ProductDto> products = new ArrayList<>();

        for (EProductCategory e : categories) {
            products.add(ProductDto.builder().
                    category(CategoryDto.builder().
                            name(e.toString()).
                            build()).
                    build());
        }

        return products;
    }

    @Test
    public void whenClientIsGoldAndProductIsBasicAndApplyOneYearMemberAndItsClientBirthday() {
        Calendar memberCal = Calendar.getInstance();
        memberCal.set(Calendar.YEAR, memberCal.get(Calendar.YEAR) - 2);
        memberCal.set(Calendar.MONTH, 1);

        Calendar birthdateCal = Calendar.getInstance();
        birthdateCal.set(Calendar.YEAR, memberCal.get(Calendar.YEAR) - 20);

        ClientDto clientDto = ClientDto.builder().
                category(EClientCategory.GOLD).
                memberSince(memberCal.getTime()).
                birthdate(birthdateCal.getTime()).build();

        List<ProductDto> products = getProducts(EProductCategory.BASIC);
        List<ProductDto> list = discountService.getDiscountsByClientCategory(clientDto, products);
        Assertions.assertThat(list.size()).isEqualTo(1);
        org.junit.jupiter.api.Assertions.assertEquals(GoldDiscount.BASIC_LIGHT_DISCOUNT +
                OneYearDiscount.DISCOUNT + BirthdateDiscount.DISCOUNT, list.get(0).getDiscount());
    }

    @Test
    public void whenClientIsGoldAndProductIsPlusAndApplyOneYearMemberAndItsClientBirthday() {
        Calendar memberCal = Calendar.getInstance();
        memberCal.set(Calendar.YEAR, memberCal.get(Calendar.YEAR) - 2);
        memberCal.set(Calendar.MONTH, 1);

        Calendar birthdateCal = Calendar.getInstance();
        birthdateCal.set(Calendar.YEAR, memberCal.get(Calendar.YEAR) - 20);
        birthdateCal.set(Calendar.MONTH, birthdateCal.get(Calendar.MONTH) - 1);

        ClientDto clientDto = ClientDto.builder().
                category(EClientCategory.GOLD).
                memberSince(memberCal.getTime()).
                birthdate(birthdateCal.getTime()).build();

        List<ProductDto> products = getProducts(EProductCategory.PLUS);
        List<ProductDto> list = discountService.getDiscountsByClientCategory(clientDto, products);
        Assertions.assertThat(list.size()).isEqualTo(1);
        org.junit.jupiter.api.Assertions.assertEquals(GoldDiscount.PLUS_PREMIUM_DISCOUNT +
                OneYearDiscount.DISCOUNT, list.get(0).getDiscount());
    }

    @Test
    public void whenClientIsPlatinumAndProductIsLightAndApplyFiveYearsMemberAndItsClientBirthday() {
        Calendar memberCal = Calendar.getInstance();
        memberCal.set(Calendar.YEAR, memberCal.get(Calendar.YEAR) - 6);
        memberCal.set(Calendar.MONTH, 1);

        Calendar birthdateCal = Calendar.getInstance();
        birthdateCal.set(Calendar.YEAR, memberCal.get(Calendar.YEAR) - 20);

        ClientDto clientDto = ClientDto.builder().
                category(EClientCategory.PLATINUM).
                memberSince(memberCal.getTime()).
                birthdate(birthdateCal.getTime()).build();

        List<ProductDto> products = getProducts(EProductCategory.LIGHT);
        List<ProductDto> list = discountService.getDiscountsByClientCategory(clientDto, products);
        Assertions.assertThat(list.size()).isEqualTo(1);
        org.junit.jupiter.api.Assertions.assertEquals(PlatinumDiscount.BASIC_LIGHT_DISCOUNT +
                FiveYearsDiscount.DISCOUNT + BirthdateDiscount.DISCOUNT, list.get(0).getDiscount());
    }

    @Test
    public void whenClientIsPlatinumAndProductIsPremiumAndApplyFiveYearsMemberAndItsClientBirthday() {
        Calendar memberCal = Calendar.getInstance();
        memberCal.set(Calendar.YEAR, memberCal.get(Calendar.YEAR) - 6);
        memberCal.set(Calendar.MONTH, 1);

        Calendar birthdateCal = Calendar.getInstance();
        birthdateCal.set(Calendar.YEAR, memberCal.get(Calendar.YEAR) - 20);
        birthdateCal.set(Calendar.MONTH, birthdateCal.get(Calendar.MONTH) - 1);

        ClientDto clientDto = ClientDto.builder().
                category(EClientCategory.PLATINUM).
                memberSince(memberCal.getTime()).
                birthdate(birthdateCal.getTime()).build();

        List<ProductDto> products = getProducts(EProductCategory.PREMIUM);
        List<ProductDto> list = discountService.getDiscountsByClientCategory(clientDto, products);
        Assertions.assertThat(list.size()).isEqualTo(1);
        org.junit.jupiter.api.Assertions.assertEquals(PlatinumDiscount.PLUS_PREMIUM_DISCOUNT +
                FiveYearsDiscount.DISCOUNT, list.get(0).getDiscount());
    }

    @Test
    public void whenClientIsBlackAndProductIsLightAndApplyTenYearsMemberAndItsClientBirthday_thenBirthdayDiscountIsNotApplied() {
        Calendar memberCal = Calendar.getInstance();
        memberCal.set(Calendar.YEAR, memberCal.get(Calendar.YEAR) - 11);
        memberCal.set(Calendar.MONTH, 1);

        Calendar birthdateCal = Calendar.getInstance();
        birthdateCal.set(Calendar.YEAR, memberCal.get(Calendar.YEAR) - 20);

        ClientDto clientDto = ClientDto.builder().
                category(EClientCategory.BLACK).
                memberSince(memberCal.getTime()).
                birthdate(birthdateCal.getTime()).build();

        List<ProductDto> products = getProducts(EProductCategory.LIGHT);
        List<ProductDto> list = discountService.getDiscountsByClientCategory(clientDto, products);
        Assertions.assertThat(list.size()).isEqualTo(1);
        org.junit.jupiter.api.Assertions.assertEquals(BlackDiscount.BASIC_LIGHT_DISCOUNT +
                TenYearsDiscount.DISCOUNT, list.get(0).getDiscount());
    }

    @Test
    public void whenClientIsBlackAndProductIsPremiumAndApplyTenYearsMemberAndItsClientBirthday() {
        Calendar memberCal = Calendar.getInstance();
        memberCal.set(Calendar.YEAR, memberCal.get(Calendar.YEAR) - 11);
        memberCal.set(Calendar.MONTH, 1);

        Calendar birthdateCal = Calendar.getInstance();
        birthdateCal.set(Calendar.YEAR, memberCal.get(Calendar.YEAR) - 20);
        birthdateCal.set(Calendar.MONTH, birthdateCal.get(Calendar.MONTH) - 1);

        ClientDto clientDto = ClientDto.builder().
                category(EClientCategory.BLACK).
                memberSince(memberCal.getTime()).
                birthdate(birthdateCal.getTime()).build();

        List<ProductDto> products = getProducts(EProductCategory.PREMIUM);
        List<ProductDto> list = discountService.getDiscountsByClientCategory(clientDto, products);
        Assertions.assertThat(list.size()).isEqualTo(1);
        org.junit.jupiter.api.Assertions.assertEquals(BlackDiscount.PLUS_PREMIUM_DISCOUNT +
                TenYearsDiscount.DISCOUNT, list.get(0).getDiscount());
    }

}
