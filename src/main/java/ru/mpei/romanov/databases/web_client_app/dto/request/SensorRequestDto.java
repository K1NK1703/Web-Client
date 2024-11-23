package ru.mpei.romanov.databases.web_client_app.dto.request;

import java.time.LocalDate;

/**
 * DTO for {@link ru.mpei.romanov.databases.web_client_app.entity.sensor.Sensor}
 */
public record SensorRequestDto(Long id,
                               String type,
                               String location,
                               String factory,
                               String factoryLocation,
                               LocalDate installDate,
                               Long editorId,
                               Long eventId) {
}