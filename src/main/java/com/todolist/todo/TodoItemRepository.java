package com.todolist.todo;

import org.springframework.data.jpa.repository.JpaRepository;

// The JpaRepository interface takes two arguments: 
// 1. The Entity class it manages (TodoItem)
// 2. The data type of the Entity's primary key (Long)
public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
    
    // Spring Data JPA automatically provides methods like:
    // - save()
    // - findById()
    // - findAll()
    // - deleteById()
    
    // We can add custom methods just by defining the method signature, 
    // e.g., to find all uncompleted tasks:
    // List<TodoItem> findAllByCompletedFalse();
}