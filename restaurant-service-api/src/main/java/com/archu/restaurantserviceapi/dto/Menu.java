package com.archu.restaurantserviceapi.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
public class Menu {

    private final List<MenuItem> items = new ArrayList<>();

    private boolean addItem(MenuItem item) {
        return items.add(item);
    }

    private boolean removeItem(MenuItem item) {
        return items.remove(item);
    }
}
