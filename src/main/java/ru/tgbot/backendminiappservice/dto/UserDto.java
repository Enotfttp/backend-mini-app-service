package ru.tgbot.backendminiappservice.dto;

import ru.tgbot.backendminiappservice.entities.User;

import java.util.UUID;

public record UserDto(
        UUID id,
        String name
) {
    public static UserDto from(User user) {
        return new UserDto(
                user.getId(),
                user.getName()
        );
    }
}
