package com.rabf.productservice.api.controller.model.product;

import java.io.Serializable;

public class CategoryResponseDto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -1377253643777389198L;

    private long id;

    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
