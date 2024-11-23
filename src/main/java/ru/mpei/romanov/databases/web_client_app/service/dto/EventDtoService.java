package ru.mpei.romanov.databases.web_client_app.service.dto;

import ru.mpei.romanov.databases.web_client_app.dto.response.EventResponseDto;

import java.util.List;

public interface EventDtoService {

    EventResponseDto getEventDtoById(Long id);

    List<EventResponseDto> getAllEventsDto();
}
