package ru.mpei.romanov.databases.web_client_app.service.dto;

import ru.mpei.romanov.databases.web_client_app.dto.response.SensorResponseDto;

import java.util.List;

public interface SensorDtoService {

    List<SensorResponseDto> getAllSensorsDto();
}
