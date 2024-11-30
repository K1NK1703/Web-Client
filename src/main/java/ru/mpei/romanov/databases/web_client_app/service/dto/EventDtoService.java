package ru.mpei.romanov.databases.web_client_app.service.dto;

import ru.mpei.romanov.databases.web_client_app.dto.response.FactorySensorEventResponseDto;

import java.util.List;

public interface EventDtoService {

    List<FactorySensorEventResponseDto> getSensorEventsDto();
}
