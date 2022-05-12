package com.co.ias.products.types.application.services;

import com.co.ias.products.types.application.domain.Type;
import com.co.ias.products.types.application.models.TypeDTO;
import com.co.ias.products.types.application.ports.in.CreateTypeUseCase;
import com.co.ias.products.types.application.ports.out.TypeRepository;

import org.springframework.stereotype.Service;

@Service
public class CreateTypeService implements CreateTypeUseCase {
    private final TypeRepository typeRepository;

    public CreateTypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public TypeDTO excute(TypeDTO typeDTO) {

        Type type = typeDTO.toDomain();
        typeRepository.store(type);

        return typeDTO;
    }

}
