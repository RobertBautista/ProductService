package com.rabf.productservice.api.bussines;

import com.rabf.productservice.api.domain.dto.ClientDto;
import com.rabf.productservice.api.domain.dto.ProductDto;

import java.util.List;

public interface IDiscountService {

    List<ProductDto> getDiscountsByClientCategory(ClientDto client, List<ProductDto> products);

}
