package com.archu.takeawaycommonspring.exception.types;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ResourceAlreadyExistsException extends RuntimeException {
    public ResourceAlreadyExistsException() {
        super("Resource already exists");
    }

    public ResourceAlreadyExistsException(final Class<?> resourceClass, final String searchBy, final String value) {
        super(String.format("%s with %s %s already exists", resourceClass.getSimpleName(), searchBy, value));
    }

}