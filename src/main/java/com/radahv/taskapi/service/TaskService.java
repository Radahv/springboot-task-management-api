package com.radahv.taskapi.service;

import com.radahv.taskapi.dto.CreateTaskRequest;
import com.radahv.taskapi.dto.UpdateTaskRequest;
import com.radahv.taskapi.exception.NotFoundException;
import com.radahv.taskapi.model.Task;
import com.radahv.taskapi.model.User;
import com.radahv.taskapi.repository.TaskRepository;
import com.radahv.taskapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service layer containing business logic for task operations.
 * <p>
 * This layer:
 * <ul>
 *   <li>Validates relationships (task must belong to an existing user)</li>
 *   <li>Coordinates persistence using repositories</li>
 *   <li>Applies updates safely (e.g., partial updates)</li>
 * </ul>
 */
@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    /**
     * Creates a new task for an existing user.
     *
     * @param req task creation request (title, userId)
     * @return created task entity
     * @throws com.radahv.taskapi.exception.NotFoundException if the user does not exist
     */
    public Task createTask(CreateTaskRequest req) {
        User user = userRepository.findById(req.userId)
                .orElseThrow(() -> new NotFoundException("User not found"));

        Task task = new Task(req.title, user);
        return taskRepository.save(task);
    }

    /**
     * Retrieves all tasks in the system.
     *
     * @return list of all tasks
     */
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    /**
     * Updates an existing task.
     * <p>
     * Supports partial updates; only provided fields are modified.
     *
     * @param id task identifier
     * @param req update request payload
     * @return updated task
     * @throws com.radahv.taskapi.exception.NotFoundException if the task does not exist
     */
    public Task updateTask(Long id, UpdateTaskRequest req) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Task not found"));

        if (req.completed != null) {
            task.setCompleted(req.completed);
        }
        return taskRepository.save(task);
    }

    /**
     * Retrieves all tasks assigned to a specific user.
     *
     * @param userId user identifier
     * @return list of tasks for the user (empty list if none)
     */
    public List<Task> getTasksByUser(Long userId) {
        return taskRepository.findByUserId(userId);
    }
}