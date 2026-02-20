package com.radahv.taskapi.dto;

/**
 * Response DTO representing user data returned by the API.
 * <p>
 * This DTO intentionally avoids exposing internal entity details.
 */
public class UserResponse {
    public Long id;
    public String name;
    public String email;

    public UserResponse(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}