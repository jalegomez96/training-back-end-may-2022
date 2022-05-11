package com.co.ias.products.shared.domain;

import org.apache.commons.lang3.Validate;

public class PageSize {
    private final Integer value;


    public PageSize(Integer value) {
        Integer pageSize = value != null ? value : 10;
        Validate.inclusiveBetween(10, 30, pageSize, "Pagesize should be between 10 and 30");
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
