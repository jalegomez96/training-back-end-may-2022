package com.co.ias.products.types.application.services;

import com.co.ias.products.types.application.domain.TypeId;
import com.co.ias.products.types.application.ports.in.DeleteTypeUseCase;
import com.co.ias.products.types.application.ports.out.TypeRepository;

import org.springframework.stereotype.Service;

@Service
public class DeleteTypeService implements DeleteTypeUseCase {
    private final TypeRepository typeRepository;

    public DeleteTypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public Void excute(Integer id) {
        TypeId typeId = new TypeId(id);
        typeRepository.delete(typeId);
        return null;
    }
}
