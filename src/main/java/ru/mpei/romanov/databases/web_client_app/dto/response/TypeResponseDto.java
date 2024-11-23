package ru.mpei.romanov.databases.web_client_app.dto.response;

import ru.mpei.romanov.databases.web_client_app.entity.sensor.Type;

/**
 * DTO for {@link Type}
 */
public record TypeResponseDto(Long id,
                              String name) {
}