package com.archu.takeawaycommonspring.base;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public interface BaseConverter<D extends BaseDTO, E extends BaseEntity> {

    E createFrom(D dto);

    D createFrom(E entity);

    E updateEntity(E entity, D dto);

    default List<D> createFromEntities(final Collection<E> entities) {
        return entities.stream()
                .map(this::createFrom)
                .collect(Collectors.toList());
    }

    default List<E> createFromDtos(final Collection<D> dtos) {
        return dtos.stream()
                .map(this::createFrom)
                .collect(Collectors.toList());
    }
}