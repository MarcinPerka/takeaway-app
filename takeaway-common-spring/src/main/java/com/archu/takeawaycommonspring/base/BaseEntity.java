package com.archu.takeawaycommonspring.base;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

import java.time.Instant;

@Getter
@SuperBuilder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
public abstract class BaseEntity {

    @Id
    private final String id;

    @Version
    private final Integer version;

    @CreatedDate
    private final Instant createdAt;

    @LastModifiedDate
    private final Instant updatedAt;

}