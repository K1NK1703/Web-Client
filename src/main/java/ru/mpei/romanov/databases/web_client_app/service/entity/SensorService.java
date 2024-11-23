package ru.mpei.romanov.databases.web_client_app.service.entity;

import ru.mpei.romanov.databases.web_client_app.entity.sensor.Sensor;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface SensorService {

    Optional<Sensor> findSensorById(Long id);

    Optional<Sensor> findSensorByTypeIdAndInstallDate(Long typeId, LocalDate installDate);

    Optional<Sensor> findSensorByEventIdAndLocation(Long eventId, String location);

    List<Sensor> findAllSensors();

    void saveSensor(Sensor sensor);

    void updateSensor(Sensor sensor);

    void deleteSensorById(Long id);
}
