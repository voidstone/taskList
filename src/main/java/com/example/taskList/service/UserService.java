package com.example.taskList.service;

import com.example.taskList.domain.user.User;

public interface UserService {

    User getById(Long id);

    User getByUsername(String username);

    User create(User user);

    User update(User user);

    User delete(Long id);

    boolean isTaskOwner(Long taskId, Long userId);
}
