package com.co.ias.products.products.application.ports.out;

import com.co.ias.products.products.application.domain.Product;
import com.co.ias.products.products.application.domain.ProductId;
import com.co.ias.products.shared.domain.PageQuery;

import java.util.List;

public interface ProductRepository {
    Integer store(Product product);
    Product get(ProductId productId);
    void update(Product product);
    void delete(ProductId productId);
    List<Product> getProducts(PageQuery pageQuery);
}
