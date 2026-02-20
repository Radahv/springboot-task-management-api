package com.radahv.taskapi.exception;

/**
 * Exception thrown when a requested resource cannot be found.
 * <p>
 * Typically mapped to HTTP 404 by {@link com.radahv.taskapi.exception.GlobalExceptionHandler}.
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}