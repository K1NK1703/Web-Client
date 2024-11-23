package ru.mpei.romanov.databases.web_client_app.dto.response;

import ru.mpei.romanov.databases.web_client_app.entity.sensor.Factory;

/**
 * DTO for {@link Factory}
 */
public record FactoryResponseDto(Long id,
                                 String name,
                                 String location) {
}