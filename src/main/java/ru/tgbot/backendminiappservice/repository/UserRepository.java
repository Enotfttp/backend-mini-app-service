package ru.tgbot.backendminiappservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tgbot.backendminiappservice.entities.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
