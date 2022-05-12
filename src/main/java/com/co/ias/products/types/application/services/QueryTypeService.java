package com.co.ias.products.types.application.services;

import java.util.Optional;

import com.co.ias.products.types.application.domain.Type;
import com.co.ias.products.types.application.domain.TypeId;
import com.co.ias.products.types.application.models.TypeDTO;
import com.co.ias.products.types.application.ports.in.QueryTypeUseCase;
import com.co.ias.products.types.application.ports.out.TypeRepository;

import org.springframework.stereotype.Service;

@Service
public class QueryTypeService implements QueryTypeUseCase {
    private final TypeRepository typeRepository;

    public QueryTypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public Optional<TypeDTO> excute(Integer id) {
        TypeId typeId = new TypeId(id);
        Optional<Type> type = typeRepository.get(typeId);
        return type.map(type1 -> {
            TypeDTO typeDTO = TypeDTO.fromDomain(type1);
            return typeDTO;
        });
    }

}
