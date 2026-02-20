package com.radahv.taskapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class CreateUserRequest {

    @NotBlank(message = "Name is required")
    public String name;

    @Email(message = "Email must be valid")
    @NotBlank(message = "Email is required")
    public String email;
}