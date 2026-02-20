package com.radahv.taskapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateTaskRequest {

    @NotBlank(message = "Title is required")
    public String title;

    @NotNull(message = "UserId is required")
    public Long userId;
}