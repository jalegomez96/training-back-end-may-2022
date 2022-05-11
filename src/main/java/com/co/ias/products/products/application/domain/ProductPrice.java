package com.co.ias.products.products.application.domain;

import org.apache.commons.lang3.Validate;

public class ProductPrice {
    private final Integer value;


    public ProductPrice(Integer value) {
        Validate.notNull(value, "Price of product can not be null");
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
