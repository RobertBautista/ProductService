package com.rabf.productservice.api.product.data;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

	ProductEntity findByProductId(String productId);

}
