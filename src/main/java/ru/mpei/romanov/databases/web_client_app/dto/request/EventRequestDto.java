package ru.mpei.romanov.databases.web_client_app.dto.request;

import java.time.LocalDateTime;

public record EventRequestDto(Long id,
                              Long sensorId,
                              LocalDateTime time,
                              Double temperature,
                              Double pressure,
                              Double gasEmission,
                              Double airQuality,
                              String loggingLevel) {
}
