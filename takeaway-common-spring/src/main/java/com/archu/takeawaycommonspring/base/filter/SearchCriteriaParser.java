package com.archu.takeawaycommonspring.base.filter;

import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class SearchCriteriaParser {

    public List<SearchCriteria> parseMultiValueMapToSearchCriteria(final MultiValueMap<String, Object> params) {
        return params.entrySet().stream().flatMap(it -> {
            final var field = substringBeforeLast('.', it.getKey());
            final var operator = substringAfterLast('.', it.getKey());
            final var operation = operator != null ? SearchOperation.valueOfOperator(operator) : SearchOperation.EQUALITY;

            return it.getValue().size() == 1
                    ? Stream.of(SearchCriteria.of(field, operation, it.getValue().get(0)))
                    : it.getValue().stream().map(value -> SearchCriteria.of(field, operation, value));
        }).collect(Collectors.toList());
    }

    private String substringBeforeLast(final char delimiter, final String value) {
        final var index = value.lastIndexOf(delimiter);
        return index == -1 ? value : value.substring(0, index);
    }

    private String substringAfterLast(final char delimiter, final String value) {
        final var index = value.lastIndexOf(delimiter);
        return index == -1 ? null : value.substring(index + 1);
    }

}
