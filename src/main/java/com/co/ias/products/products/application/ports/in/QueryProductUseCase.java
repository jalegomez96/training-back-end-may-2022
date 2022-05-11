package com.co.ias.products.products.application.ports.in;

import com.co.ias.products.commons.UseCase;
import com.co.ias.products.products.application.domain.ProductId;
import com.co.ias.products.products.application.models.ProductDTO;

import java.util.Optional;

public interface QueryProductUseCase extends UseCase<Integer, Optional<ProductDTO>> {
}
