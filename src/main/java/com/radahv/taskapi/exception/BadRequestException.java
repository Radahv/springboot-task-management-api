package com.radahv.taskapi.exception;

/**
 * Exception thrown when a request violates a business rule or is invalid.
 * <p>
 * Typically mapped to HTTP 400 by {@link com.radahv.taskapi.exception.GlobalExceptionHandler}.
 */
public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}