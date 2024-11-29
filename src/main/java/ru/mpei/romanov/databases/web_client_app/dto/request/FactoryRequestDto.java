package ru.mpei.romanov.databases.web_client_app.dto.request;

import ru.mpei.romanov.databases.web_client_app.entity.sensor.Factory;

/**
 * DTO for {@link Factory}
 */
public record FactoryRequestDto(Long id,
                                String name,
                                String location) {
}