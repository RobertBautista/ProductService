package com.rabf.productservice.api.enums;

public enum EProductCategory {
    BASIC(1),
    LIGHT(2),
    PLUS(3),
    PREMIUM(4);

    private long id;

    EProductCategory (long id){
        this.id = id;
    }

    public long getId() {
        return id;
    }

}
