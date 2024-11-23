package ru.mpei.romanov.databases.web_client_app.dto.request;

/**
 * DTO for {@link ru.mpei.romanov.databases.web_client_app.entity.User}
 */
public record UserRequestDto(Long id,
                             String username,
                             String password) {
}