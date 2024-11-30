package ru.mpei.romanov.databases.web_client_app.dto.response;

public record UserResponseDto(Long id,
                              String username,
                              String roles) {
}