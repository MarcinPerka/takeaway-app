package com.archu.reviewservice.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "reviews")
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@EqualsAndHashCode
@ToString
public class Review {

    @Id
    private final String id;

    private final String author;

    private final String message;

    private final int rating;

    private final Restaurant restaurant;

    @CreatedDate
    private final LocalDateTime createdAt;

    @LastModifiedDate
    private final LocalDateTime modifiedAt;
}
