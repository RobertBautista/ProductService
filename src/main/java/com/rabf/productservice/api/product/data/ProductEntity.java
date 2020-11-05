package com.rabf.productservice.api.product.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5606610429524061364L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "productId", nullable = false, unique = true)
	private String productId;
	
	@Column(nullable = false, length = 20, unique = true)
	private String name;
	
	@Column(nullable = false, length = 20)
	private String mark;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private CategoryEntity category;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

}
