package ru.mpei.romanov.databases.web_client_app.repository.dto;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.mpei.romanov.databases.web_client_app.entity.event.Event;
import ru.mpei.romanov.databases.web_client_app.dto.response.FactorySensorEventResponseDto;

import java.util.List;
import java.sql.Timestamp;
import java.util.Optional;

public interface EventDtoRepository extends JpaRepository<Event, Long> {

    @Query(value = "SELECT * FROM public.factorysensorevents", nativeQuery = true)
    Optional<List<Object[]>> getSensorEvents();

    default List<FactorySensorEventResponseDto> getSensorEventsDto() {
        List<Object[]> rawResults = getSensorEvents().orElseThrow(() -> new RuntimeException("No sensor events found"));
        return rawResults.stream().map(result -> new FactorySensorEventResponseDto(
                (String) result[0],
                (String) result[1],
                (String) result[2],
                (String) result[3],
                ((Timestamp) result[4]).toLocalDateTime(),
                Double.parseDouble(result[5].toString()),
                Double.parseDouble(result[6].toString()),
                Double.parseDouble(result[7].toString()),
                Double.parseDouble(result[8].toString()),
                (String) result[9],
                (String) result[10]
        )).toList();
    }
}
