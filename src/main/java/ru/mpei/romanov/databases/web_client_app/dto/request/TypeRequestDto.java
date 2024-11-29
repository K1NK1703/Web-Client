package ru.mpei.romanov.databases.web_client_app.dto.request;

import ru.mpei.romanov.databases.web_client_app.entity.sensor.Type;

/**
 * DTO for {@link Type}
 */
public record TypeRequestDto(Long id,
                             String name) {
}