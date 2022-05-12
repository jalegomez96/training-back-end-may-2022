package com.co.ias.products.types.application.models;

import com.co.ias.products.types.application.domain.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TypeDBO {
    private Integer id;
    private String name;

    public TypeDBO() {
    }

    public TypeDBO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static TypeDBO fromResultSet(ResultSet resultSet) throws SQLException {
        TypeDBO typeDBO = new TypeDBO();
        typeDBO.setId(resultSet.getInt("id"));
        typeDBO.setName(resultSet.getString("name").trim());

        return typeDBO;
    }

    public Type toDomain() {
        return new Type(
                new TypeId(id),
                new TypeName(name));
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
