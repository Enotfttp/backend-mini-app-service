package ru.tgbot.backendminiappservice.service;

import ru.tgbot.backendminiappservice.dto.TaskDto;
import ru.tgbot.backendminiappservice.enums.TaskStatusEnum;

import java.util.List;
import java.util.UUID;

public interface TaskService {
    TaskDto getTask(UUID uuid);

    void deleteTask(UUID uuid);

    TaskDto addTask(TaskDto taskDto);

    TaskDto updateTask(UUID uuid, TaskDto taskDto);

    TaskDto updateTaskStatus(UUID uuid, TaskStatusEnum status);

    List<TaskDto> getAllTasks();
}
