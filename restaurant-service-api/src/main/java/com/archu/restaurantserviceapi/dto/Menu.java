package com.archu.restaurantserviceapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Menu {

    @NotEmpty
    private List<@Valid MenuItem> items;

    private boolean addItem(MenuItem item) {
        return items.add(item);
    }

    private boolean removeItem(MenuItem item) {
        return items.remove(item);
    }
}
