package com.radahv.taskapi.service;

import com.radahv.taskapi.dto.CreateUserRequest;
import com.radahv.taskapi.dto.UserResponse;
import com.radahv.taskapi.exception.BadRequestException;
import com.radahv.taskapi.exception.NotFoundException;
import com.radahv.taskapi.model.User;
import com.radahv.taskapi.repository.UserRepository;
import org.springframework.stereotype.Service;


/**
 * Service layer containing business logic for user operations.
 * <p>
 * This layer:
 * <ul>
 *   <li>Enforces domain rules (e.g., unique email)</li>
 *   <li>Coordinates data access through repositories</li>
 *   <li>Maps entities to response DTOs</li>
 * </ul>
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Creates a new user after validating uniqueness constraints.
     *
     * @param req user creation request
     * @return created user response DTO
     * @throws com.radahv.taskapi.exception.BadRequestException if email already exists
     */
    public UserResponse createUser(CreateUserRequest req) {
        if (userRepository.existsByEmail(req.email)) {
            throw new BadRequestException("Email already exists");
        }
        User user = new User(req.name, req.email);
        User saved = userRepository.save(user);
        return new UserResponse(saved.getId(), saved.getName(), saved.getEmail());
    }

    /**
     * Retrieves a user by id.
     *
     * @param id user identifier
     * @return user response DTO
     * @throws com.radahv.taskapi.exception.NotFoundException if the user does not exist
     */
    public UserResponse getUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));
        return new UserResponse(user.getId(), user.getName(), user.getEmail());
    }
}