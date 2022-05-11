package com.co.ias.products.products.application.domain;

import org.apache.commons.lang3.Validate;

public class ProductId {
    private final Integer value;

    public ProductId(Integer value) {
        Validate.notNull(value, "Product id can not be null");
        Validate.isTrue(value < 99999999, "Product id can not be longer than 8 characters");
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
