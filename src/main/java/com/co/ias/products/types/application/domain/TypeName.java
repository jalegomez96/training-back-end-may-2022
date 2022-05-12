package com.co.ias.products.types.application.domain;

import org.apache.commons.lang3.Validate;

public class TypeName {
    private final String value;

    public TypeName(String value) {
        Validate.notNull(value, "Type name can not be null");
        Validate.isTrue(value.length() < 40, "Type name can not be longer then 40 characters");
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

}
