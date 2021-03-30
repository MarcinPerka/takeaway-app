package com.archu.restaurantserviceapi.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
@ToString
public class Menu {

    @NotEmpty
    private final List<@Valid MenuItem> items = new ArrayList<>();

    private boolean addItem(MenuItem item) {
        return items.add(item);
    }

    private boolean removeItem(MenuItem item) {
        return items.remove(item);
    }
}
