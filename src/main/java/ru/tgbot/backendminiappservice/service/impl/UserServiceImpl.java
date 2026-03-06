package ru.tgbot.backendminiappservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tgbot.backendminiappservice.dto.UserDto;
import ru.tgbot.backendminiappservice.entities.User;
import ru.tgbot.backendminiappservice.mapper.UserMapper;
import ru.tgbot.backendminiappservice.repository.UserRepository;
import ru.tgbot.backendminiappservice.service.UserService;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto getUser(UUID uuid) {
        return userRepository.findById(uuid)
                .map(userMapper::toDto)
                .orElseThrow(() -> new RuntimeException("User not found: " + uuid));
    }

    @Override
    public void deleteUser(UUID uuid) {
        userRepository.deleteById(uuid);
    }

    @Override
    public UserDto addUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User user = userRepository.findById(userDto.id())
                .orElseThrow(() -> new RuntimeException("User not found: " + userDto.id()));
        userMapper.updateEntity(userDto, user);
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .toList();
    }
}
