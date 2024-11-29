package ru.mpei.romanov.databases.web_client_app.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record FactorySensorEventDto(String factoryName,
                                    String factoryLocation,
                                    String sensorLocation,
                                    String sensorType,
                                    LocalDateTime eventTime,
                                    BigDecimal eventTemperature,
                                    BigDecimal eventPressure,
                                    BigDecimal eventGasEmission,
                                    BigDecimal eventAirQuality,
                                    BigDecimal eventLoggingLevel,
                                    String zoneLevel) {
}
