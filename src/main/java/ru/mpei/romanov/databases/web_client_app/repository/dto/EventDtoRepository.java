package ru.mpei.romanov.databases.web_client_app.repository.dto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.mpei.romanov.databases.web_client_app.dto.response.EventResponseDto;
import ru.mpei.romanov.databases.web_client_app.entity.event.Event;

import java.util.List;
import java.util.Optional;

public interface EventDtoRepository extends JpaRepository<Event, Long> {

    @Query("""
            SELECT new ru.mpei.romanov.databases.web_client_app.dto.response.EventResponseDto(
            e.id, e.time, a.airQuality, g.gasEmission, l.loggingLevel, p.pressure, t.temperature)
            FROM Event e
            LEFT JOIN AirQualityEvent a ON e.id = a.id
            LEFT JOIN GasEmissionEvent g ON a.id = g.id
            LEFT JOIN LoggingEvent l ON g.id = l.id
            LEFT JOIN PressureEvent p ON l.id = p.id
            LEFT JOIN TemperatureEvent t ON p.id = t.id""")
    Optional<List<EventResponseDto>> getAllEventsDto();

    @Query("""
            SELECT new ru.mpei.romanov.databases.web_client_app.dto.response.EventResponseDto(
            e.id, e.time, a.airQuality, g.gasEmission, l.loggingLevel, p.pressure, t.temperature)
            FROM Event e
            LEFT JOIN AirQualityEvent a ON e.id = a.id
            LEFT JOIN GasEmissionEvent g ON a.id = g.id
            LEFT JOIN LoggingEvent l ON g.id = l.id
            LEFT JOIN PressureEvent p ON l.id = p.id
            LEFT JOIN TemperatureEvent t ON p.id = t.id
            WHERE e.id = :id""")
    Optional<EventResponseDto> getEventDtoById(@Param("id") Long id);
}
