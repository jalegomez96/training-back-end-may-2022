package com.co.ias.products.types.application.ports.out;

import java.util.List;
import java.util.Optional;

import com.co.ias.products.shared.domain.PageQuery;
import com.co.ias.products.types.application.domain.Type;
import com.co.ias.products.types.application.domain.TypeId;

public interface TypeRepository {
    void store(Type type);

    Optional<Type> get(TypeId typeId);

    void update(Type type);

    void delete(TypeId typeId);

    List<Type> getTypes(PageQuery pageQuery);
}
