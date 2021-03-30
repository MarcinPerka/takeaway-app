package com.archu.reviewservice.domain;

import com.archu.takeawaycommonspring.base.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Immutable;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reviews")
@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@ToString
public class Review extends BaseEntity {

    private final String author;

    private final String message;

    private final int rating;

    private final String restaurantId;

}
