package ru.mpei.romanov.databases.web_client_app.service.entity;

import ru.mpei.romanov.databases.web_client_app.entity.sensor.Sensor;

import java.util.List;

public interface SensorService {

    Sensor findSensorById(Long id);

    List<Sensor> findAllSensors();

    List<Sensor> getTopSensors();

    void saveSensor(Sensor sensor);

    void updateSensor(Long id, Sensor sensor);

    void deleteSensorById(Long id);
}
