package com.rabf.productservice.api.bussines;

import com.rabf.productservice.api.bussines.discount.*;
import com.rabf.productservice.api.domain.dto.ClientDto;
import com.rabf.productservice.api.domain.dto.ProductDto;
import com.rabf.productservice.api.utils.DateUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountServiceImpl implements IDiscountService {

    @Override
    public List<ProductDto> getDiscountsByClientCategory(ClientDto client, List<ProductDto> products) {
        DiscountContext discountContext = new DiscountContext();
        addDiscountByClientCategory(client, discountContext);

        addDiscountByTime(client, discountContext);

        addDiscountByBirthdate(client, discountContext);

        for (ProductDto productDto : products) {
            discountContext.executeStrategy(productDto);
        }

        return products;
    }

    private void addDiscountByBirthdate(ClientDto client, DiscountContext discountContext) {
        if (DateUtils.isSameCurrentDayAndMonth(client.getBirthdate())) {
            discountContext.addStrategy(BirthdateDiscount.getInstance());
        }
    }

    private void addDiscountByTime(ClientDto client, DiscountContext discountContext) {
        int years = DateUtils.getYearsElapsedUntilToday(client.getMemberSince());
        if (years > 10) {
            discountContext.addStrategy(TenYearsDiscount.getInstance());
        } else if (years > 5) {
            discountContext.addStrategy(FiveYearsDiscount.getInstance());
        } else if (years > 1) {
            discountContext.addStrategy(OneYearDiscount.getInstance());
        }
    }

    private void addDiscountByClientCategory(ClientDto client, DiscountContext discountContext) {
        switch (client.getCategory()) {
            case GOLD:
                discountContext.addStrategy(GoldDiscount.getInstance());
                break;
            case PLATINUM:
                discountContext.addStrategy(PlatinumDiscount.getInstance());
                break;
            case BLACK:
                discountContext.addStrategy(BlackDiscount.getInstance());
                break;
        }
    }
}
