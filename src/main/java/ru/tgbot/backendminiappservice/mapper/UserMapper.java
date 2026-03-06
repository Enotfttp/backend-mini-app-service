package ru.tgbot.backendminiappservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.tgbot.backendminiappservice.dto.UserDto;
import ru.tgbot.backendminiappservice.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "calendars", ignore = true)
    @Mapping(target = "tasks", ignore = true)
    User toEntity(UserDto userDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "calendars", ignore = true)
    @Mapping(target = "tasks", ignore = true)
    void updateEntity(UserDto userDto, @MappingTarget User user);
}
