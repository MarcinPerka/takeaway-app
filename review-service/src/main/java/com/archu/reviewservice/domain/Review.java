package com.archu.reviewservice.domain;

import com.archu.takeawaycommonspring.base.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reviews")
@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@ToString
public class Review extends BaseEntity {

    private String author;

    private String message;

    private int rating;

    private String restaurantId;

}
