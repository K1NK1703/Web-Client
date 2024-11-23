package ru.mpei.romanov.databases.web_client_app.repository.entity.sensor;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mpei.romanov.databases.web_client_app.entity.sensor.Sensor;

import java.time.LocalDate;
import java.util.Optional;

public interface SensorRepository extends JpaRepository<Sensor, Long> {

    Optional<Sensor> findByTypeIdAndInstallDate(Long typeId, LocalDate installDate);

    Optional<Sensor> findByEventIdAndLocation(Long eventId, String location);
}
