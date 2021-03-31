package com.archu.takeawaycommonspring.base.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.*;

import java.time.Instant;

@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
public abstract class BaseEntity {

    @Id
    protected String id;

    @Version
    protected Integer version;

    @CreatedDate
    protected Instant createdAt;

    @LastModifiedDate
    protected Instant updatedAt;

}