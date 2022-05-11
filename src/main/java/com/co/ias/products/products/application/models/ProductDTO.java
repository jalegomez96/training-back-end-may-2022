package com.co.ias.products.products.application.models;

import com.co.ias.products.products.application.domain.*;

public class ProductDTO {
    private Integer productId;
    private Integer typeOfProduct;
    private String name;
    private Integer price;
    private Integer discount;

    public ProductDTO() {
    }

    public ProductDTO(Integer productId, Integer typeOfProduct, String name, Integer price, Integer discount) {
        this.productId = productId;
        this.typeOfProduct = typeOfProduct;
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public Product toDomain() {
        return new Product(
                new ProductId(productId),
                new ProductName(name),
                new TypeOfProduct(typeOfProduct),
                new ProductPrice(price),
                new ProductDiscount(discount)
        );
    }

    public static ProductDTO fromDomain(Product product) {
        return new ProductDTO(
                product.getProductId().getValue(),
                product.getTypeOfProduct().getValue(),
                product.getProductName().getValue(),
                product.getProductPrice().getValue(),
                product.getProductDiscount().getValue()
        );
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getTypeOfProduct() {
        return typeOfProduct;
    }

    public void setTypeOfProduct(Integer typeOfProduct) {
        this.typeOfProduct = typeOfProduct;
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

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }
}
