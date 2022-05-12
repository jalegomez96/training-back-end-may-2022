package com.co.ias.products.types.application.services;

import com.co.ias.products.types.application.domain.Type;
import com.co.ias.products.types.application.models.TypeDTO;
import com.co.ias.products.types.application.ports.in.UpdateTypeUseCase;
import com.co.ias.products.types.application.ports.out.TypeRepository;

import org.springframework.stereotype.Service;

@Service
public class UpdateTypeService implements UpdateTypeUseCase {
    private final TypeRepository typeRepository;

    public UpdateTypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public TypeDTO excute(TypeDTO typeDTO) {
        Type type = typeDTO.toDomain();
        typeRepository.update(type);
        return typeDTO;
    }

}
