package com.rabf.productservice.api.bussines;

import com.rabf.productservice.api.domain.Client;
import com.rabf.productservice.api.domain.Product;

import java.util.List;

public interface IDiscountService {

    List<Product> getDiscountsByClientCategory(Client client, List<Product> products);

}
