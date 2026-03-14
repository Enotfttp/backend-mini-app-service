package ru.tgbot.backendminiappservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.tgbot.backendminiappservice.dto.TaskDto;
import ru.tgbot.backendminiappservice.enums.TaskStatusEnum;
import ru.tgbot.backendminiappservice.service.TaskService;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tasks")
@Slf4j
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<List<TaskDto>> getAllTasks() {
        log.info("Getting all tasks");
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<TaskDto> getTask(@PathVariable UUID uuid) {
        log.info("Getting task: {}", uuid);
        return ResponseEntity.ok(taskService.getTask(uuid));
    }

    @PostMapping
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto) {
        log.info("Creating task: {}", taskDto);
        return ResponseEntity.ok(taskService.addTask(taskDto));
    }

    @PatchMapping("/{uuid}/status")
    public ResponseEntity<TaskDto> updateTaskStatus(@PathVariable UUID uuid, @RequestBody TaskStatusEnum status) {
        log.info("Updating task {} status to {}", uuid, status);
        return ResponseEntity.ok(taskService.updateTaskStatus(uuid, status));
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable UUID uuid, @RequestBody TaskDto taskDto) {
        log.info("Updating task: {}", uuid);
        return ResponseEntity.ok(taskService.updateTask(uuid, taskDto));
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deleteTask(@PathVariable UUID uuid) {
        log.info("Deleting task: {}", uuid);
        taskService.deleteTask(uuid);
        return ResponseEntity.noContent().build();
    }
}
