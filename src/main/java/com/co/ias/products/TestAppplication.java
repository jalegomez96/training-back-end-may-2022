package com.co.ias.products;

import com.co.ias.products.products.application.domain.*;
import com.co.ias.products.products.application.models.ProductDTO;

public class TestAppplication {
    public static void main(String[] args) {
        try {
            ProductId productId = new ProductId(123);
            ProductName productName = new ProductName("headphones");
            ProductPrice productPrice = new ProductPrice(100);
            ProductDiscount productDiscount = new ProductDiscount(80);
            TypeOfProduct typeOfProduct = new TypeOfProduct(2);

            Product product = new Product(productId, productName, typeOfProduct, productPrice, productDiscount);

            // output
            ProductDTO productDTO = new ProductDTO(1, 1, "headphones", 100, 100);

            // input para repository
            Product product1 = productDTO.toDomain();

        } catch (NullPointerException | IllegalArgumentException exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }
}
