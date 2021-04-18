package com.archu.takeawaycommonspring.base.filter;

import com.querydsl.core.types.dsl.*;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@RequiredArgsConstructor
public abstract class BasePredicate<T> {

    private final SearchCriteria searchCriteria;

    public abstract BooleanExpression getPredicate(final Class<T> tClass, final String collectionName);

    protected BooleanExpression getStringPredicate(final StringPath stringPath, final String value) {
        switch (searchCriteria.getSearchOperation()) {
            case EQUALITY:
                return stringPath.eq(value);
            case NEGATION:
                return stringPath.ne(value);
            case CONTAINS:
                return stringPath.contains(value);
            case STARTS_WITH:
                return stringPath.startsWith(value);
            default:
                return null;
        }
    }

    protected BooleanExpression getIntegerPredicate(final NumberPath<Integer> numberPath, final Integer value) {
        switch (searchCriteria.getSearchOperation()) {
            case EQUALITY:
                return numberPath.eq(value);
            case NEGATION:
                return numberPath.ne(value);
            case GREATER_THAN:
                return numberPath.gt(value);
            case GREATER_THAN_OR_EQUAL:
                return numberPath.goe(value);
            case LESS_THAN:
                return numberPath.lt(value);
            case LESS_THAN_OR_EQUAL:
                return numberPath.loe(value);
            default:
                return null;
        }
    }

    protected BooleanExpression getBigDecimalPredicate(final NumberPath<BigDecimal> numberPath, final BigDecimal value) {
        switch (searchCriteria.getSearchOperation()) {
            case EQUALITY:
                return numberPath.eq(value);
            case NEGATION:
                return numberPath.ne(value);
            case GREATER_THAN:
                return numberPath.gt(value);
            case GREATER_THAN_OR_EQUAL:
                return numberPath.goe(value);
            case LESS_THAN:
                return numberPath.lt(value);
            case LESS_THAN_OR_EQUAL:
                return numberPath.loe(value);
            default:
                return null;
        }
    }

    protected BooleanExpression getInstantPredicate(final DateTimePath<Instant> datePath, final Instant value) {
        switch (searchCriteria.getSearchOperation()) {
            case EQUALITY:
                return datePath.eq(value);
            case NEGATION:
                return datePath.ne(value);
            case GREATER_THAN:
                return datePath.gt(value);
            case GREATER_THAN_OR_EQUAL:
                return datePath.goe(value);
            case LESS_THAN:
                return datePath.lt(value);
            case LESS_THAN_OR_EQUAL:
                return datePath.loe(value);
            default:
                return null;
        }
    }


}

