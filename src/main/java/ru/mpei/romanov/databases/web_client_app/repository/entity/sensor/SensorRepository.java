package ru.mpei.romanov.databases.web_client_app.repository.entity.sensor;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.mpei.romanov.databases.web_client_app.entity.sensor.Sensor;

import java.util.List;
import java.util.Optional;

public interface SensorRepository extends JpaRepository<Sensor, Long> {

    @Query(value = "SELECT * FROM public.get_top_10_sensors()", nativeQuery = true)
    Optional<List<Sensor>> getTopSensors();
}
