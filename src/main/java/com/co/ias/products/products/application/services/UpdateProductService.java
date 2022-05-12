package com.co.ias.products.products.application.services;

import com.co.ias.products.products.application.domain.Product;
import com.co.ias.products.products.application.models.ProductDTO;
import com.co.ias.products.products.application.ports.in.UpdateProductUseCase;
import com.co.ias.products.products.application.ports.out.ProductRepository;

import org.springframework.stereotype.Service;

@Service
public class UpdateProductService implements UpdateProductUseCase {
    private final ProductRepository productRepository;

    public UpdateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTO excute(ProductDTO productDTO) {
        Product product = productDTO.toDomain();
        productRepository.update(product);
        return productDTO;
    }

}
