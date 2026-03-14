package ru.tgbot.backendminiappservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.tgbot.backendminiappservice.dto.CalendarDto;
import ru.tgbot.backendminiappservice.entities.Calendar;

@Mapper(componentModel = "spring")
public interface CalendarMapper {

    @Mapping(source = "mainPerson.id", target = "userId")
    CalendarDto toDto(Calendar calendar);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "mainPerson", ignore = true)
    @Mapping(target = "secondaryPerson", ignore = true)
    Calendar toEntity(CalendarDto calendarDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "mainPerson", ignore = true)
    @Mapping(target = "secondaryPerson", ignore = true)
    void updateEntity(CalendarDto calendarDto, @MappingTarget Calendar calendar);
}
