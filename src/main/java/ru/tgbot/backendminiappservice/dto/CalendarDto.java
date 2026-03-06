package ru.tgbot.backendminiappservice.dto;


import ru.tgbot.backendminiappservice.entities.Calendar;

import java.time.LocalDateTime;
import java.util.UUID;

public record CalendarDto(
        UUID id,
        String title,
        String description,
        LocalDateTime dateTime,
        UUID userId
) {
    public static CalendarDto from(Calendar calendar) {
        return new CalendarDto(
                calendar.getId(),
                calendar.getTitle(),
                calendar.getDescription(),
                calendar.getDateTime(),
                calendar.getMainPerson() != null ? calendar.getMainPerson().getId() : null
        );
    }
}
