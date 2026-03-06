package ru.tgbot.backendminiappservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.tgbot.backendminiappservice.dto.TaskDto;
import ru.tgbot.backendminiappservice.service.TaskService;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<List<TaskDto>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<TaskDto> getTask(@PathVariable UUID uuid) {
        return ResponseEntity.ok(taskService.getTask(uuid));
    }

    @PostMapping
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto) {
        return ResponseEntity.ok(taskService.addTask(taskDto));
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deleteTask(@PathVariable UUID uuid) {
        taskService.deleteTask(uuid);
        return ResponseEntity.noContent().build();
    }
}
