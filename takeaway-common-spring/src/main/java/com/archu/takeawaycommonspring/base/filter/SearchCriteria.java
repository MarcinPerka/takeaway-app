package com.archu.takeawaycommonspring.base.filter;

import lombok.Getter;

@Getter
public class SearchCriteria {
    private final String field;
    private final SearchOperation searchOperation;
    private final Object value;

    private SearchCriteria(final String field, final SearchOperation searchOperation, final Object value) {
        this.field = field;
        this.searchOperation = searchOperation;
        this.value = value;
    }

    public static SearchCriteria of(final String field, final SearchOperation searchOperation, final Object value) {
        return new SearchCriteria(field, searchOperation, value);
    }
}

