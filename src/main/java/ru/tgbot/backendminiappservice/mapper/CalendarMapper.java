package ru.tgbot.backendminiappservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.tgbot.backendminiappservice.dto.CalendarDto;
import ru.tgbot.backendminiappservice.entities.Calendar;

@Mapper
public interface CalendarMapper {

    CalendarDto toDto(Calendar calendar);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    Calendar toEntity(CalendarDto calendarDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "mainPerson", ignore = true)
    @Mapping(target = "secondaryPerson", ignore = true)
    void updateEntity(CalendarDto calendarDto, @MappingTarget Calendar calendar);
}
