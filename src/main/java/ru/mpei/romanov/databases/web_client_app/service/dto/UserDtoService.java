package ru.mpei.romanov.databases.web_client_app.service.dto;

import ru.mpei.romanov.databases.web_client_app.dto.response.UserResponseDto;

import java.util.List;

public interface UserDtoService {

    List<UserResponseDto> getAllUsersDto();
}
