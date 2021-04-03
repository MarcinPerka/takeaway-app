package com.archu.takeawaycommonspring.base.domain;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public interface BaseConverter<IN extends BaseRequest, OUT extends BaseResponse, E extends BaseEntity> {

    E createFrom(final IN dto);

    OUT createFrom(final E entity);

    E updateEntity(final E entity, final IN dto);

    default List<OUT> createFromEntities(final Collection<E> entities) {
        return entities.stream()
                .map(this::createFrom)
                .collect(Collectors.toList());
    }

    default List<E> createFromDtos(final Collection<IN> dtos) {
        return dtos.stream()
                .map(this::createFrom)
                .collect(Collectors.toList());
    }
}