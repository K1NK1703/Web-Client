package ru.mpei.romanov.databases.web_client_app.service.dto;

import ru.mpei.romanov.databases.web_client_app.dto.response.TypeResponseDto;

import java.util.List;

public interface TypeDtoService {

    List<TypeResponseDto> getAllTypesDto();
}
