package com.archu.takeawaycommonspring.base.filter;

import java.util.Arrays;

public enum SearchOperation {

    EQUALITY("eq"), NEGATION("neq"), LESS_THAN("lt"), GREATER_THAN("gt"),
    GREATER_THAN_OR_EQUAL("gte"), LESS_THAN_OR_EQUAL("lte"), CONTAINS("like"), STARTS_WITH("startsWith");

    private final String operator;

    SearchOperation(final String operator) {
        this.operator = operator;
    }

    public static SearchOperation valueOfOperator(final String operator) {
        return Arrays.stream(values()).filter(it -> it.operator.equals(operator)).findFirst().orElseThrow(IllegalArgumentException::new);
    }
}
