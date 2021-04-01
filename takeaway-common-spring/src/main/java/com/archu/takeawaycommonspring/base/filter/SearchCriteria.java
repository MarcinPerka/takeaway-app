package com.archu.takeawaycommonspring.base.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.StringUtils;

import java.util.List;

@Getter
@AllArgsConstructor
@ToString
class SearchCriteria {

    private static final List<String> OPERATIONS = List.of("=", "gt", "lt", "gte", "lte");

    private final String key;
    private final String operation;
    private final String value;

    public boolean isValid() {
        return StringUtils.hasText(key) && OPERATIONS.contains(operation) && StringUtils.hasText(value);
    }

}