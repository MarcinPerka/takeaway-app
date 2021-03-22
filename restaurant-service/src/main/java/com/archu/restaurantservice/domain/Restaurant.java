package com.archu.restaurantservice.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Document(collection = "restaurants")
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@EqualsAndHashCode
@ToString
public class Restaurant {

    @Id
    private String id;

    private final String name;

    private final Set<Cuisine> cuisineTypes = new HashSet<>();

    private final Set<Shipping> shippingTypes = new HashSet<>();

    private final Location location;

    @CreatedDate
    private final LocalDateTime createdAt;

    @LastModifiedDate
    private final LocalDateTime modifiedAt;
}
