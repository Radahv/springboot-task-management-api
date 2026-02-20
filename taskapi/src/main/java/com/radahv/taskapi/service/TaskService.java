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

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public Task createTask(CreateTaskRequest req) {
        User user = userRepository.findById(req.userId)
                .orElseThrow(() -> new NotFoundException("User not found"));

        Task task = new Task(req.title, user);
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task updateTask(Long id, UpdateTaskRequest req) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Task not found"));

        if (req.completed != null) {
            task.setCompleted(req.completed);
        }
        return taskRepository.save(task);
    }

    public List<Task> getTasksByUser(Long userId) {
        return taskRepository.findByUserId(userId);
    }
}