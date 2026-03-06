package ru.tgbot.backendminiappservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tgbot.backendminiappservice.entities.Calendar;

import java.util.UUID;

public interface CalendarRepository extends JpaRepository<Calendar, UUID> {
}
