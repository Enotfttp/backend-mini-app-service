package ru.tgbot.backendminiappservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.tgbot.backendminiappservice.dto.CalendarDto;
import ru.tgbot.backendminiappservice.service.CalendarService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/calendar-events")
public class CalendarController {

    private final CalendarService calendarService;

    @GetMapping
    public ResponseEntity<List<CalendarDto>> getAllCalendartEvents() {
        return ResponseEntity.ok(calendarService.getAllCalendarEvents());
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<CalendarDto> getCalendarEvent(@PathVariable UUID uuid) {
        return ResponseEntity.ok(calendarService.getCalendarEvent(uuid));
    }

    @PostMapping
    public ResponseEntity<CalendarDto> createCalendarEvent(@RequestBody CalendarDto calendarDto) {
        return ResponseEntity.ok(calendarService.addCalendarEvent(calendarDto));
    }

    @PutMapping
    public ResponseEntity<CalendarDto> updateCalendarEvent(@RequestBody CalendarDto calendarDto) {
        return ResponseEntity.ok(calendarService.updateCalendarEvent(calendarDto));
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deleteCalendarEvent(@PathVariable UUID uuid) {
        calendarService.deleteCalendarEvent(uuid);
        return ResponseEntity.noContent().build();
    }
}
