package ru.tgbot.backendminiappservice.service;

import ru.tgbot.backendminiappservice.dto.TaskDto;

import java.util.List;
import java.util.UUID;

public interface TaskService {
    TaskDto getTask(UUID uuid);

    void deleteTask(UUID uuid);

    TaskDto addTask(TaskDto taskDto);

    TaskDto updateTask(TaskDto taskDto);

    List<TaskDto> getAllTasks();
}
