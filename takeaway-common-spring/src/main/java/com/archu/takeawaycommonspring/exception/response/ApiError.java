package com.archu.takeawaycommonspring.exception.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@EqualsAndHashCode
@ToString
public class ApiError {

    /**
     * Http Status
     */
    private final HttpStatus status;

    /**
     * internal error message for a developer
     */
    private final String message;

    /**
     * error code in a string representation; it can be an exception name e.g. MissingDeliveryPointException
     */
    private final String code;

    /**
     * localized message (based on Accept-Language header) to be presented to an application user (much more general than a message); can be null
     */
    private final String userMessage;

    /**
     * more specific message for an internal developer; it will be null in case of a production environment
     */
    private final String details;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private final LocalDateTime timestamp = LocalDateTime.now();

    /**
     * information about failed parameters validation; can be null
     */
    private final List<BaseApiSubError> subErrors = new ArrayList<>();

    public static ApiError create(HttpStatus httpStatus, String message, String code) {
        return new ApiError(httpStatus, message, code, null, null);
    }

    public static ApiError create(HttpStatus httpStatus, String message, String code, String details) {
        return new ApiError(httpStatus, message, code, null, details);
    }

    public static ApiError create(HttpStatus httpStatus, String message, String code, String userMessage, String details) {
        return new ApiError(httpStatus, message, code, userMessage, details);
    }

    private void addSubError(BaseApiSubError subError) {
        subErrors.add(subError);
    }

    private void addValidationError(String object, String field, Object rejectedValue, String message) {
        addSubError(ApiValidationError.create(object, field, rejectedValue, message));
    }

    private void addValidationError(String object, String message) {
        addSubError(ApiValidationError.create(object, message));
    }

    private void addValidationError(FieldError fieldError) {
        this.addValidationError(
                fieldError.getObjectName(),
                fieldError.getField(),
                fieldError.getRejectedValue(),
                fieldError.getDefaultMessage());
    }

    public void addValidationErrors(List<FieldError> fieldErrors) {
        fieldErrors.forEach(this::addValidationError);
    }

    private void addValidationError(ObjectError objectError) {
        this.addValidationError(
                objectError.getObjectName(),
                objectError.getDefaultMessage());
    }

    public void addValidationError(List<ObjectError> globalErrors) {
        globalErrors.forEach(this::addValidationError);
    }
}