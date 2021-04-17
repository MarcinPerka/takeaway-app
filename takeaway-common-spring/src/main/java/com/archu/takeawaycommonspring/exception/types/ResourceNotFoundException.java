package com.archu.takeawaycommonspring.exception.types;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super("Resource was not found");
    }

    public ResourceNotFoundException(final Class<?> resourceClass, final String searchBy, final String value) {
        super(String.format("%s with %s %s was not found", resourceClass.getSimpleName(), searchBy, value));
    }

}