package ru.tgbot.backendminiappservice.service;

import ru.tgbot.backendminiappservice.dto.CalendarDto;

import java.util.List;
import java.util.UUID;

public interface CalendarService {

    List<CalendarDto> getAllCalendarEvents();

    CalendarDto getCalendarEvent(UUID uuid);

    void deleteCalendarEvent(UUID uuid);

    CalendarDto addCalendarEvent(CalendarDto calendarDto);

    CalendarDto updateCalendarEvent(CalendarDto calendarDto);
}
