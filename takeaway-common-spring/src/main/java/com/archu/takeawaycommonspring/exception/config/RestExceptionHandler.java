package com.archu.takeawaycommonspring.exception.config;

import com.archu.takeawaycommonspring.exception.types.BadRequestException;
import com.archu.takeawaycommonspring.exception.response.ApiError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Handle MissingServletRequestParameterException. Triggered when a 'required' request parameter is missing.
     *
     * @param ex      MissingServletRequestParameterException
     * @param headers HttpHeaders
     * @param status  HttpStatus
     * @param request WebRequest
     * @return the ApiError object
     */
    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(
            final MissingServletRequestParameterException ex, final HttpHeaders headers,
            final HttpStatus status, final WebRequest request) {
        final var error = ex.getParameterName() + " parameter is missing";
        return buildResponseEntity(ApiError.create(HttpStatus.BAD_REQUEST, error, ex.getClass().getSimpleName()));
    }


    /**
     * Handle HttpMediaTypeNotSupportedException. This one triggers when JSON is invalid as well.
     *
     * @param ex      HttpMediaTypeNotSupportedException
     * @param headers HttpHeaders
     * @param status  HttpStatus
     * @param request WebRequest
     * @return the ApiError object
     */
    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(
            final HttpMediaTypeNotSupportedException ex,
            final HttpHeaders headers,
            final HttpStatus status,
            final WebRequest request) {
        final var builder = new StringBuilder();
        builder.append(ex.getContentType());
        builder.append(" media type is not supported. Supported media types are ");
        ex.getSupportedMediaTypes().forEach(t -> builder.append(t).append(", "));
        return buildResponseEntity(ApiError.create(HttpStatus.UNSUPPORTED_MEDIA_TYPE, builder.substring(0, builder.length() - 2), ex.getClass().getSimpleName()));
    }

    /**
     * Handle MethodArgumentNotValidException. Triggered when an object fails @Valid validation.
     *
     * @param ex      the MethodArgumentNotValidException that is thrown when @Valid validation fails
     * @param headers HttpHeaders
     * @param status  HttpStatus
     * @param request WebRequest
     * @return the ApiError object
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            final MethodArgumentNotValidException ex,
            final HttpHeaders headers,
            final HttpStatus status,
            final WebRequest request) {
        final var apiError = ApiError.create(HttpStatus.UNPROCESSABLE_ENTITY, "Validation error", ex.getClass().getSimpleName());
        apiError.addValidationErrors(ex.getBindingResult().getFieldErrors());
        apiError.addValidationError(ex.getBindingResult().getGlobalErrors());
        return buildResponseEntity(apiError);
    }

    /**
     * Handle BindException. Triggered when an object fails @Valid validation.
     *
     * @param ex      the BindException that is thrown when @Valid validation fails
     * @param headers HttpHeaders
     * @param status  HttpStatus
     * @param request WebRequest
     * @return the ApiError object
     */
    @Override
    protected ResponseEntity<Object> handleBindException(final BindException ex, final HttpHeaders headers,
                                                         final HttpStatus status, final WebRequest request) {
        final var apiError = ApiError.create(HttpStatus.BAD_REQUEST, "Validation error", ex.getClass().getSimpleName());
        apiError.addValidationErrors(ex.getBindingResult().getFieldErrors());
        apiError.addValidationError(ex.getBindingResult().getGlobalErrors());
        return buildResponseEntity(apiError);
    }

    /**
     * Handle HttpMessageNotReadableException. Happens when request JSON is malformed.
     *
     * @param ex      HttpMessageNotReadableException
     * @param headers HttpHeaders
     * @param status  HttpStatus
     * @param request WebRequest
     * @return the ApiError object
     */
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(final HttpMessageNotReadableException ex, final HttpHeaders headers,
                                                                  final HttpStatus status, final WebRequest request) {
        final var servletWebRequest = (ServletWebRequest) request;
        log.info("{} to {}", servletWebRequest.getHttpMethod(), servletWebRequest.getRequest().getServletPath());
        final var error = "Malformed JSON request";
        return buildResponseEntity(ApiError.create(HttpStatus.BAD_REQUEST, error, ex.getClass().getSimpleName()));
    }

    /**
     * Handle HttpMessageNotWritableException.
     *
     * @param ex      HttpMessageNotWritableException
     * @param headers HttpHeaders
     * @param status  HttpStatus
     * @param request WebRequest
     * @return the ApiError object
     */
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotWritable(final HttpMessageNotWritableException ex, final HttpHeaders headers,
                                                                  final HttpStatus status, final WebRequest request) {
        final var error = "Error writing JSON output";
        return buildResponseEntity(ApiError.create(HttpStatus.INTERNAL_SERVER_ERROR, error, ex.getClass().getSimpleName()));
    }

    /**
     * Handle NoHandlerFoundException.
     *
     * @param ex      NoHandlerFoundException
     * @param headers HttpHeaders
     * @param status  HttpStatus
     * @param request WebRequest
     * @return the ApiError object
     */
    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(final NoHandlerFoundException ex, final HttpHeaders headers,
                                                                   final HttpStatus status, final WebRequest request) {
        final var apiError = ApiError.create(HttpStatus.BAD_REQUEST,
                String.format("Could not find the %s method for URL %s", ex.getHttpMethod(), ex.getRequestURL()), ex.getClass().getSimpleName(), ex.getMessage());
        return buildResponseEntity(apiError);
    }

    /**
     * Handle MethodArgumentTypeMismatchException.
     *
     * @param ex MethodArgumentTypeMismatchException
     * @return the ApiError object
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    private ResponseEntity<?> handleMethodArgumentTypeMismatchException(final MethodArgumentTypeMismatchException ex) {
        final var apiError = ApiError.create(HttpStatus.BAD_REQUEST, "Could not convert parameter.", ex.getClass().getSimpleName(), ex.getMessage());
        return buildResponseEntity(apiError);
    }


    /**
     * Handle BadRequestException.
     *
     * @param ex BadRequestException
     * @return the ApiError object
     */
    @ExceptionHandler(BadRequestException.class)
    private ResponseEntity<?> handleBadRequestException(final BadRequestException ex) {
        final var apiError = ApiError.create(HttpStatus.BAD_REQUEST, "Bad request error.", ex.getClass().getSimpleName(), ex.getMessage());
        return buildResponseEntity(apiError);
    }

    /**
     * Hanlde exceptions of other types.
     *
     * @param ex Exception
     * @return the ApiError object
     */
    @ExceptionHandler(Exception.class)
    private ResponseEntity<?> handleException(final Exception ex) {
        final var apiError = ApiError.create(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error.", ex.getClass().getSimpleName(), ex.getMessage());
        return buildResponseEntity(apiError);
    }

    private ResponseEntity<Object> buildResponseEntity(final ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

}