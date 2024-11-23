package ru.mpei.romanov.databases.web_client_app.dto.request;

/**
 * DTO for {@link ru.mpei.romanov.databases.web_client_app.entity.Editor}
 */
public record EditorRequestDto(Long id,
                               String lastName,
                               String firstName,
                               String middleName,
                               String post,
                               String phoneNumber) {
}