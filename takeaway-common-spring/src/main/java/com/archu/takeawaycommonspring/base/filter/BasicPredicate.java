package com.archu.takeawaycommonspring.base.filter;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.PathBuilder;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Optional;

@AllArgsConstructor
public class BasicPredicate<T> {

    private final SearchCriteria criteria;

    public BooleanExpression getPredicate(final Class<T> clazz, final String collectionName) {
        var entityPath = new PathBuilder<>(clazz, collectionName);

        return Optional.ofNullable(getDatePredicate(entityPath))
                .orElse(Optional.ofNullable(getNumberPredicate(entityPath))
                        .orElse(Optional.ofNullable(getStringPredicate(entityPath)).orElse(null)));
    }

    private BooleanExpression getStringPredicate(PathBuilder<T> entityPath) {
        var stringPath = entityPath.getString(criteria.getKey());
        return criteria.getOperation().equals("=")
                ? stringPath.eq(criteria.getValue())
                : null;
    }

    private BooleanExpression getDatePredicate(PathBuilder<T> entityPath) {
        if (isNumber(criteria.getValue())) {
            var numPath = entityPath.getNumber(criteria.getKey(), BigDecimal.class);
            var parsedValue = new BigDecimal(criteria.getValue());
            switch (criteria.getOperation()) {
                case "=":
                    return numPath.eq(parsedValue);
                case "gt":
                    return numPath.gt(parsedValue);
                case "lt":
                    return numPath.lt(parsedValue);
                case "lte":
                    return numPath.loe(parsedValue);
                case "gte":
                    return numPath.goe(parsedValue);
            }
        }
        return null;
    }

    private BooleanExpression getNumberPredicate(PathBuilder<T> entityPath) {
        if (isDate(criteria.getValue())) {
            var datePath = entityPath.getDate(criteria.getKey(), LocalDate.class);
            var parsedValue = LocalDate.parse(criteria.getValue());
            switch (criteria.getOperation()) {
                case "=":
                    return datePath.eq(parsedValue);
                case "gt":
                    return datePath.gt(parsedValue);
                case "lt":
                    return datePath.lt(parsedValue);
                case "lte":
                    return datePath.loe(parsedValue);
                case "gte":
                    return datePath.goe(parsedValue);
            }
        }
        return null;
    }

    private boolean isDate(String value) {
        try {
            LocalDate.parse(value);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

    private boolean isNumber(String value) {
        try {
            new BigDecimal(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}