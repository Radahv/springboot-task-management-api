package com.radahv.taskapi.repository;

import com.radahv.taskapi.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository interface for {@link com.radahv.taskapi.model.Task}.
 * <p>
 * Provides CRUD operations and task lookup queries.
 */
public interface TaskRepository extends JpaRepository<Task, Long> {
    /**
     * Returns tasks belonging to the given user id.
     *
     * @param userId user identifier
     * @return list of tasks assigned to the user
     */
    List<Task> findByUserId(Long userId);
}