package com.archu.takeawaycommonspring.exception.response;

import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@EqualsAndHashCode(callSuper = true)
@ToString
class ApiValidationError extends BaseApiSubError {

    private final String object;

    private final String field;

    private final Object rejectedValue;

    private final String message;


    public static ApiValidationError create(final String object, final String field, final Object rejectedValue, final String message) {
        return new ApiValidationError(object, field, rejectedValue, message);
    }

    public static ApiValidationError create(final String object, final String message) {
        return create(object, null, null, message);
    }

}