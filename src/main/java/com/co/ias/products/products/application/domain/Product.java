package com.co.ias.products.products.application.domain;

public class Product {
    private final ProductId productId;
    private final ProductName productName;
    private final TypeOfProduct typeOfProduct;
    private final ProductPrice productPrice;
    private final ProductDiscount productDiscount;

    public Product(ProductId productId, ProductName productName, TypeOfProduct typeOfProduct, ProductPrice productPrice, ProductDiscount productDiscount) {
        this.productId = productId;
        this.productName = productName;
        this.typeOfProduct = typeOfProduct;
        this.productPrice = productPrice;
        this.productDiscount = productDiscount;
    }

    public ProductId getProductId() {
        return productId;
    }

    public ProductName getProductName() {
        return productName;
    }

    public TypeOfProduct getTypeOfProduct() {
        return typeOfProduct;
    }

    public ProductPrice getProductPrice() {
        return productPrice;
    }

    public ProductDiscount getProductDiscount() {
        return productDiscount;
    }
}
