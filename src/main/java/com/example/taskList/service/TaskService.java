package com.example.taskList.service;

import com.example.taskList.domain.task.Task;

import java.util.List;

public interface TaskService {

    Task getById(Long id);

    List<Task> getAllByUserId(Long id);

    Task create(Task task, Long userId);

    Task update(Task task);

    void delete(Long id);
}
