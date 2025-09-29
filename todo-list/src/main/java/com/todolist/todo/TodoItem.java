package com.todolist.todo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import jakarta.persistence.PrePersist; // <-- NEW IMPORT
import jakarta.persistence.Column;     // <-- NEW IMPORT

@Entity
public class TodoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Task description is required")
    private String description;
    
    private boolean completed;
    
    @Column(nullable = false, updatable = false) // Ensures column is non-null and not changed after creation
    private LocalDateTime createdAt; // The field to store the timestamp

    // Default constructor is required by JPA
    public TodoItem() {
    }

    // Constructor for creating new items
    public TodoItem(String description) {
        this.description = description;
        this.completed = false;
        // The date is now set by the @PrePersist method, not here.
    }
    
    // NEW METHOD: This is called automatically by JPA before the entity is saved (persisted).
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
    
    // Getters and Setters (remain the same)
    public Long getId() {
        return id;
    }
    // ... (All other Getters/Setters and toString remain the same) ...
    public void setId(Long id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public boolean isCompleted() {
        return completed;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}