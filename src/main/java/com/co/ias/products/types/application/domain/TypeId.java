package com.co.ias.products.types.application.domain;

import org.apache.commons.lang3.Validate;

public class TypeId {
    private final Integer value;

    public TypeId(Integer value) {
        Validate.notNull(value, "Type id can not be null");
        Validate.isTrue(value < 99999999, "Type id can not be longer then 8 characters");
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
