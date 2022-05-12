package com.co.ias.products.types.application.ports.in;

import java.util.Optional;

import com.co.ias.products.commons.UseCase;
import com.co.ias.products.types.application.models.TypeDTO;

public interface QueryTypeUseCase extends UseCase<Integer, Optional<TypeDTO>> {

}
