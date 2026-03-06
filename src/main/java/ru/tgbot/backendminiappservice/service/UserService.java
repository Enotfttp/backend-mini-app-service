package ru.tgbot.backendminiappservice.service;

import ru.tgbot.backendminiappservice.dto.UserDto;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserDto getUser(UUID uuid);

    void deleteUser(UUID uuid);

    UserDto addUser(UserDto userDto);

    UserDto updateUser(UserDto userDto);

    List<UserDto> getAllUsers();
}
