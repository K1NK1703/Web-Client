package ru.mpei.romanov.databases.web_client_app.dto.response;

import java.time.LocalDateTime;

public record FactorySensorEventResponseDto(String factoryName,
                                            String factoryLocation,
                                            String sensorLocation,
                                            String sensorType,
                                            LocalDateTime eventTime,
                                            Double eventTemperature,
                                            Double eventPressure,
                                            Double eventGasEmission,
                                            Double eventAirQuality,
                                            String eventLoggingLevel,
                                            String zoneLevel) {
}
