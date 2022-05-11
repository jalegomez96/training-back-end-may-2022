package com.co.ias.products.infrastructure.adapters.out;

import com.co.ias.products.products.application.domain.Product;
import com.co.ias.products.products.application.domain.ProductId;
import com.co.ias.products.products.application.ports.out.ProductRepository;
import com.co.ias.products.shared.domain.PageQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MongoDBProductRepository implements ProductRepository {
    @Override
    public Integer store(Product product) {
        return null;
    }

    @Override
    public Product get(ProductId productId) {
        return null;
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(ProductId productId) {

    }

    @Override
    public List<Product> getProducts(PageQuery pageQuery) {
        return null;
    }
}
