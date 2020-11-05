package com.rabf.productservice.api.dto;

import com.rabf.productservice.api.enums.EProductCategory;
import lombok.*;

import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryDto implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -1377253643777389187L;

    private long id;

    private String name;

    public EProductCategory getProductCategory() {
        return EProductCategory.valueOf(this.name.toUpperCase());
    }
}
