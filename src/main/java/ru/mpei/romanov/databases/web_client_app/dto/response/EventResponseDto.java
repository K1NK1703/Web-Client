package ru.mpei.romanov.databases.web_client_app.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * DTO for {@link ru.mpei.romanov.databases.web_client_app.entity.event.Event}
 */
public record EventResponseDto(Long id,
                               LocalDateTime time,
                               BigDecimal airQuality,
                               BigDecimal gasEmission,
                               String loggingLevel,
                               BigDecimal pressure,
                               BigDecimal temperature) {
}