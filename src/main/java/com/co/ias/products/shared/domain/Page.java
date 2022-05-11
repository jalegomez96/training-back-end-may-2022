package com.co.ias.products.shared.domain;

import org.apache.commons.lang3.Validate;

public class Page {
    private final Integer value;


    public Page(Integer value) {
        Integer page = value != null ? value : 1;
        Validate.exclusiveBetween(1, 10, page, "Page value should be between 1 and 10");
        this.value = page;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
