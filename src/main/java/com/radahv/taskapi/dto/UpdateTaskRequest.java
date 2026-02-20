package com.radahv.taskapi.dto;

/**
 * Request DTO used to update an existing task.
 * <p>
 * Supports partial updates (fields may be null).
 */
public class UpdateTaskRequest {
    public Boolean completed;
}