package com.co.ias.products.products.application.models;

import com.co.ias.products.products.application.domain.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDBO {
    private Integer id;
    private String name;
    private Integer price;
    private Integer typeOfProduct;

    public ProductDBO() {
    }

    public ProductDBO(Integer id, String name, Integer price, Integer typeOfProduct) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.typeOfProduct = typeOfProduct;
    }

    public static ProductDBO fromResultSet(ResultSet resultSet) throws SQLException {
        ProductDBO productDBO = new ProductDBO();
        productDBO.setId(resultSet.getInt("id"));
        productDBO.setName(resultSet.getString("name").trim());
        productDBO.setTypeOfProduct((resultSet.getInt("type_of_product")));
        productDBO.setPrice(resultSet.getInt("price"));

        return productDBO;
    }

    public Product toDomain() {
        return new Product(
                new ProductId(id),
                new ProductName(name),
                new TypeOfProduct(typeOfProduct),
                new ProductPrice(price),
                new ProductDiscount(10)
        );
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getTypeOfProduct() {
        return typeOfProduct;
    }

    public void setTypeOfProduct(Integer typeOfProduct) {
        this.typeOfProduct = typeOfProduct;
    }
}
