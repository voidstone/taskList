package com.example.taskList.web.controller;

import com.example.taskList.domain.task.Task;
import com.example.taskList.domain.user.User;
import com.example.taskList.service.TaskService;
import com.example.taskList.service.UserService;
import com.example.taskList.web.dto.task.TaskDto;
import com.example.taskList.web.dto.user.UserDto;
import com.example.taskList.web.dto.validation.OnCreate;
import com.example.taskList.web.dto.validation.OnUpdate;
import com.example.taskList.web.mappers.TaskMapper;
import com.example.taskList.web.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Validated
public class UserController {

    private final UserService userService;
    private final TaskService taskService;

    private final UserMapper userMapper;
    private final TaskMapper taskMapper;

    @PutMapping
    public UserDto update(@Validated(OnUpdate.class)
                          @RequestBody UserDto dto) {
        User user = userMapper.toEntity(dto);
        User updatedUser = userService.update(user);
        return userMapper.toDto(updatedUser);
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable Long id) {
        User user = userService.getById(id);
        return userMapper.toDto(user);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable final Long id) {
        userService.delete(id);
    }


    @GetMapping("/{id}/tasks")
    public List<TaskDto> getTasksByUserId(@PathVariable Long id) {
        List<Task> tasks = taskService.getAllByUserId(id);
        return taskMapper.toDto(tasks);
    }


    @PostMapping("/{id}/tasks")
    public TaskDto createTask(@PathVariable final Long id,
                              @Validated(OnCreate.class)
                              @RequestBody final TaskDto dto) {
        Task task = taskMapper.toEntity(dto);
        Task createdTask = taskService.create(task, id);
        return taskMapper.toDto(createdTask);
    }

}
