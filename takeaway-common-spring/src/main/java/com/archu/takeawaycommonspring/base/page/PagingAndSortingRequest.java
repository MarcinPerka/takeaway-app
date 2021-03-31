package com.archu.takeawaycommonspring.base.page;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PagingAndSortingRequest {

    public static Pageable of(final int page, final int size, final List<String> sortingFields) {

        final var sortingOrders = sortingFields.stream().distinct().map(PagingAndSortingRequest::getOrder)
                .collect(Collectors.toList());

        final var sort = sortingOrders.isEmpty() ? Sort.unsorted() : Sort.by(sortingOrders);

        return PageRequest.of(page, size, sort);
    }

    private static Sort.Order getOrder(String value) {
        final var leadingElement = value.charAt(0);
        return new Sort.Order(getDirection(leadingElement), getProperty(value, leadingElement));
    }

    private static String getProperty(final String element, final char leadingElement) {
        return leadingElement == '-' ? element.substring(1) : element;
    }

    private static Sort.Direction getDirection(final char leadingElement) {
        return leadingElement == '-' ? Sort.Direction.DESC : Sort.Direction.ASC;
    }

}