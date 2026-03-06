package ru.tgbot.backendminiappservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tgbot.backendminiappservice.dto.CalendarDto;
import ru.tgbot.backendminiappservice.entities.Calendar;
import ru.tgbot.backendminiappservice.mapper.CalendarMapper;
import ru.tgbot.backendminiappservice.repository.CalendarRepository;
import ru.tgbot.backendminiappservice.service.CalendarService;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CalendarServiceImpl implements CalendarService {

    private final CalendarRepository calendarRepository;
    private final CalendarMapper calendarMapper;

    @Override
    public List<CalendarDto> getAllCalendarEvents() {
        return calendarRepository.findAll().stream()
                .map(calendarMapper::toDto)
                .toList();
    }

    @Override
    public CalendarDto getCalendarEvent(UUID uuid) {
        return calendarRepository.findById(uuid).map(calendarMapper::toDto).
                orElseThrow(() -> new RuntimeException("Calendar event not found: " + uuid));
    }

    @Override
    public void deleteCalendarEvent(UUID uuid) {
        calendarRepository.deleteById(uuid);
    }

    @Override
    public CalendarDto addCalendarEvent(CalendarDto calendarDto) {
        Calendar calendar = calendarMapper.toEntity(calendarDto);

        return calendarMapper.toDto(calendarRepository.save(calendar));
    }

    @Override
    public CalendarDto updateCalendarEvent(CalendarDto calendarDto) {
        Calendar calendar = calendarRepository
                .findById(calendarDto.id())
                .orElseThrow(() -> new RuntimeException("Calendar event not found: " + calendarDto.id()));

        calendarMapper.updateEntity(calendarDto, calendar);

        return calendarMapper.toDto(calendarRepository.save(calendar));
    }
}
