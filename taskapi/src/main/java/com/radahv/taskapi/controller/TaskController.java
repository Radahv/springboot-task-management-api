package com.radahv.taskapi.controller;

import com.radahv.taskapi.dto.CreateTaskRequest;
import com.radahv.taskapi.dto.UpdateTaskRequest;
import com.radahv.taskapi.model.Task;
import com.radahv.taskapi.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task create(@Valid @RequestBody CreateTaskRequest req) {
        return taskService.createTask(req);
    }

    @GetMapping
    public List<Task> getAll() {
        return taskService.getAllTasks();
    }

    @PutMapping("/{id}")
    public Task update(@PathVariable Long id,
                       @RequestBody UpdateTaskRequest req) {
        return taskService.updateTask(id, req);
    }

    @GetMapping("/user/{userId}")
    public List<Task> getByUser(@PathVariable Long userId) {
        return taskService.getTasksByUser(userId);
    }
}