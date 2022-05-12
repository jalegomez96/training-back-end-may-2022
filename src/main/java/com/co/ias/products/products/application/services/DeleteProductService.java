package com.co.ias.products.products.application.services;

import com.co.ias.products.products.application.domain.ProductId;
import com.co.ias.products.products.application.ports.in.DeleteProductUseCase;
import com.co.ias.products.products.application.ports.out.ProductRepository;

import org.springframework.stereotype.Service;

@Service
public class DeleteProductService implements DeleteProductUseCase {

    private final ProductRepository productRepository;

    public DeleteProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Void excute(Integer id) {
        ProductId productId = new ProductId(id);
        productRepository.delete(productId);
        return null;
    }

}
