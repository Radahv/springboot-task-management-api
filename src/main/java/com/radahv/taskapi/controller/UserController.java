package com.radahv.taskapi.controller;

import com.radahv.taskapi.dto.CreateUserRequest;
import com.radahv.taskapi.dto.UserResponse;
import com.radahv.taskapi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


/**
 * REST controller that exposes endpoints for user operations.
 * <p>
 * Responsibilities:
 * <ul>
 *   <li>Handle HTTP requests/responses for users</li>
 *   <li>Validate incoming payloads</li>
 *   <li>Delegate business logic to {@link com.radahv.taskapi.service.UserService}</li>
 * </ul>
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Creates a new user.
     *
     * @param req request payload containing user details (name and email)
     * @return created user representation
     * @throws com.radahv.taskapi.exception.BadRequestException if email already exists
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse create(@Valid @RequestBody CreateUserRequest req) {
        return userService.createUser(req);
    }

    /**
     * Retrieves a user by id.
     *
     * @param id user identifier
     * @return user representation
     * @throws com.radahv.taskapi.exception.NotFoundException if the user does not exist
     */
    @GetMapping("/{id}")
    public UserResponse get(@PathVariable Long id) {
        return userService.getUser(id);
    }
}