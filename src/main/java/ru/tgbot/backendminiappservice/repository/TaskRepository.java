package ru.tgbot.backendminiappservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tgbot.backendminiappservice.entities.Task;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
}
