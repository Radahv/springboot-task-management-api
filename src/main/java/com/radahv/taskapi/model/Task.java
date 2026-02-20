package com.radahv.taskapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

/**
 * Task entity representing a unit of work assigned to a user.
 * <p>
 * Each task belongs to exactly one user (many-to-one relationship).
 */
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private boolean completed = false;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore // evita un loop infinito al devolver JSON (User -> Tasks -> User…).
    private User user;

    public Task() {}

    public Task(String title, User user) {
        this.title = title;
        this.user = user;
    }

    // Getters/Setters
    public Long getId() { return id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}