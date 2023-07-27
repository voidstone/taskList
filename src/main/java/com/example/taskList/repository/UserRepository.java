package com.example.taskList.repository;

import com.example.taskList.domain.user.Role;
import com.example.taskList.domain.user.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findById(Long Id);

    Optional<User> findByUsername(String username);

    void update(User user);

    void create(User user);

    void insertUserRole(Long userId, Role role);

    boolean isTaskOwner(Long userId, Long taskId);

    void delete(Long id);
}
