package ru.mpei.romanov.databases.web_client_app.dto.response;

/**
 * DTO for {@link ru.mpei.romanov.databases.web_client_app.entity.User}
 */
public record UserResponseDto(Long id,
                              String username,
                              String roles) {
}