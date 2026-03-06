package ru.tgbot.backendminiappservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tgbot.backendminiappservice.dto.TaskDto;
import ru.tgbot.backendminiappservice.entities.Task;
import ru.tgbot.backendminiappservice.mapper.TaskMapper;
import ru.tgbot.backendminiappservice.repository.TaskRepository;
import ru.tgbot.backendminiappservice.service.TaskService;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Override
    public TaskDto getTask(UUID uuid) {
        return taskRepository
                .findById(uuid).map(taskMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Task not found: " + uuid));
    }

    @Override
    public void deleteTask(UUID uuid) {
        taskRepository.deleteById(uuid);
    }

    @Override
    public TaskDto addTask(TaskDto taskDto) {
        Task task = taskMapper.toEntity(taskDto);

        return taskMapper.toDto(taskRepository.save(task));
    }

    @Override
    public TaskDto updateTask(TaskDto taskDto) {
        Task task = taskRepository.findById(taskDto.id())
                .orElseThrow(() -> new RuntimeException("Task not found: " + taskDto.id()));
        taskMapper.updateEntity(taskDto, task);

        return taskMapper.toDto(taskRepository.save(task));
    }

    @Override
    public List<TaskDto> getAllTasks() {
        return taskRepository.findAll().stream()
                .map(taskMapper::toDto)
                .toList();
    }
}
