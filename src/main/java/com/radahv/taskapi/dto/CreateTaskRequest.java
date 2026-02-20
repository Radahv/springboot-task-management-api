package com.radahv.taskapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Request DTO used to create a new task.
 * <p>
 * Contains the task title and the target user id.
 */
public class CreateTaskRequest {

    @NotBlank(message = "Title is required")
    public String title;

    @NotNull(message = "UserId is required")
    public Long userId;
}