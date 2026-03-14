package ru.tgbot.backendminiappservice.dto;

import ru.tgbot.backendminiappservice.entities.Task;
import ru.tgbot.backendminiappservice.enums.TaskPriorityEnum;
import ru.tgbot.backendminiappservice.enums.TaskStatusEnum;
import ru.tgbot.backendminiappservice.enums.TaskTypeEnum;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskDto(
        UUID id,
        String description,
        LocalDateTime createDateTime,
        String todoTime,
        TaskStatusEnum status,
        TaskTypeEnum type,
        TaskPriorityEnum priority,
        UUID userId
) {
    public static TaskDto from(Task task) {
        return new TaskDto(
                task.getId(),
                task.getDescription(),
                task.getCreateDateTime(),
                task.getTodoTime(),
                task.getStatus(),
                task.getType(),
                task.getPriority(),
                task.getUser() != null ? task.getUser().getId() : null
        );
    }
}
