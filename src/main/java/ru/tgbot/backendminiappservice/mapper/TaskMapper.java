package ru.tgbot.backendminiappservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.tgbot.backendminiappservice.dto.TaskDto;
import ru.tgbot.backendminiappservice.entities.Task;

@Mapper
public interface TaskMapper {

    TaskDto toDto(Task task);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    Task toEntity(TaskDto taskDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    void updateEntity(TaskDto taskDto, @MappingTarget Task task);
}
