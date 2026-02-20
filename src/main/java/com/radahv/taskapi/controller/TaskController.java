package com.radahv.taskapi.controller;

import com.radahv.taskapi.dto.CreateTaskRequest;
import com.radahv.taskapi.dto.UpdateTaskRequest;
import com.radahv.taskapi.model.Task;
import com.radahv.taskapi.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller that exposes endpoints to manage tasks.
 * <p>
 * Responsibilities:
 * <ul>
 *   <li>Create tasks for existing users</li>
 *   <li>List tasks (optionally filtered by user)</li>
 *   <li>Update task status</li>
 * </ul>
 * Delegates business logic to {@link com.radahv.taskapi.service.TaskService}.
 */

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * Creates a new task for an existing user.
     *
     * @param req request payload containing task title and userId
     * @return created task
     * @throws com.radahv.taskapi.exception.NotFoundException if the user does not exist
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task create(@Valid @RequestBody CreateTaskRequest req) {
        return taskService.createTask(req);
    }


    /**
     * Returns all tasks in the system.
     *
     * @return list of tasks
     */
    @GetMapping
    public List<Task> getAll() {
        return taskService.getAllTasks();
    }

    /**
     * Updates a task (e.g., marks it as completed).
     *
     * @param id task identifier
     * @param req request payload with updatable fields
     * @return updated task
     * @throws com.radahv.taskapi.exception.NotFoundException if the task does not exist
     */
    @PutMapping("/{id}")
    public Task update(@PathVariable Long id,
                       @RequestBody UpdateTaskRequest req) {
        return taskService.updateTask(id, req);
    }

    /**
     * Returns all tasks assigned to a specific user.
     *
     * @param userId user identifier
     * @return list of tasks for the given user (empty list if none)
     */
    @GetMapping("/user/{userId}")
    public List<Task> getByUser(@PathVariable Long userId) {
        return taskService.getTasksByUser(userId);
    }
}