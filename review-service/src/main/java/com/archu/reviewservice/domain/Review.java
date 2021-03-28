package com.archu.reviewservice.domain;

import com.archu.takeawaycommonspring.base.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reviews")
@Getter
@SuperBuilder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@EqualsAndHashCode(callSuper = true)
@ToString
public class Review extends BaseEntity {

    private final String author;

    private final String message;

    private final int rating;

    private final String restaurantId;

}
