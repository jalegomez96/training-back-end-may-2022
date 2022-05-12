package com.co.ias.products.types.application.domain;

public class Type {
    private final TypeId typeId;
    private final TypeName typeName;

    public Type(TypeId typeId, TypeName typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public TypeId getTypeId() {
        return typeId;
    }

    public TypeName getTypeName() {
        return typeName;
    }

}
