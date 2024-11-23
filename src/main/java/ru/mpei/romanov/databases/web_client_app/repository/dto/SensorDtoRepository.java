package ru.mpei.romanov.databases.web_client_app.repository.dto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.mpei.romanov.databases.web_client_app.dto.response.SensorResponseDto;
import ru.mpei.romanov.databases.web_client_app.entity.sensor.Sensor;

import java.util.List;
import java.util.Optional;

public interface SensorDtoRepository extends JpaRepository<Sensor, Long> {

    @Query("""
            SELECT new ru.mpei.romanov.databases.web_client_app.dto.response.SensorResponseDto(
            s.id, t.name, s.location, f.name,
            f.location, s.installDate, s.editorId, s.eventId)
            FROM Sensor s
            JOIN Type t ON s.typeId = t.id
            JOIN Factory f ON s.factoryId = f.id""")
    Optional<List<SensorResponseDto>> getAllSensorsDto();
}
