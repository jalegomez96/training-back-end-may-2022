package com.co.ias.products.products.application.services;

import com.co.ias.products.products.application.domain.Product;
import com.co.ias.products.products.application.domain.ProductId;
import com.co.ias.products.products.application.models.ProductDTO;
import com.co.ias.products.products.application.ports.in.QueryProductUseCase;
import com.co.ias.products.products.application.ports.out.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QueryProductService implements QueryProductUseCase {

    private final ProductRepository productRepository;

    public QueryProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<ProductDTO> excute(Integer id) {

        ProductId productId = new ProductId(id);
        Optional<Product> product = productRepository.get(productId);
        return product.map(product1 -> {
            ProductDTO productDTO = ProductDTO.fromDomain(product1);
            return productDTO;
        });
    }
}
