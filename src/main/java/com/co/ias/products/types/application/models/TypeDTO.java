package com.co.ias.products.types.application.models;

import com.co.ias.products.types.application.domain.Type;
import com.co.ias.products.types.application.domain.TypeId;
import com.co.ias.products.types.application.domain.TypeName;

public class TypeDTO {
    private Integer id;
    private String name;

    public TypeDTO() {
    }

    public TypeDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Type toDomain() {
        return new Type(
                new TypeId(id),
                new TypeName(name));
    }

    public static TypeDTO fromDomain(Type type) {
        return new TypeDTO(
                type.getTypeId().getValue(),
                type.getTypeName().getValue());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
