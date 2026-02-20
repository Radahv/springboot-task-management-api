package com.radahv.taskapi.repository;

import com.radahv.taskapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository interface for {@link com.radahv.taskapi.model.User}.
 * <p>
 * Provides CRUD operations via {@link org.springframework.data.jpa.repository.JpaRepository}
 * and additional queries related to user uniqueness.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Finds a user by email.
     *
     * @param email email address
     * @return optional user
     */
    Optional<User> findByEmail(String email);

    /**
     * Checks whether a user exists with the given email.
     *
     * @param email email address
     * @return true if a user with the email exists, false otherwise
     */
    boolean existsByEmail(String email);
}