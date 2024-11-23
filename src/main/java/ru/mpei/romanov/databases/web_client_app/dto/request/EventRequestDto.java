package ru.mpei.romanov.databases.web_client_app.dto.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * DTO for {@link ru.mpei.romanov.databases.web_client_app.entity.event.Event}
 */
public record EventRequestDto(Long id,
                              LocalDateTime time,
                              BigDecimal airQuality,
                              BigDecimal gasEmission,
                              BigDecimal loggingLevel,
                              BigDecimal pressure,
                              BigDecimal temperature) {
}