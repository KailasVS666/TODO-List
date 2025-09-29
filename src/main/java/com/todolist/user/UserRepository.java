package com.todolist.user;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    
    // Spring Data JPA query method to find a user by their username
    Optional<User> findByUsername(String username);
}