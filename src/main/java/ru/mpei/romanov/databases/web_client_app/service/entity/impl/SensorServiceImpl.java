package ru.mpei.romanov.databases.web_client_app.service.entity.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mpei.romanov.databases.web_client_app.entity.sensor.Sensor;
import ru.mpei.romanov.databases.web_client_app.service.entity.SensorService;
import ru.mpei.romanov.databases.web_client_app.repository.entity.sensor.SensorRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SensorServiceImpl implements SensorService {

    private final SensorRepository sensorRepository;

    @Override
    public Sensor findSensorById(Long id) {
        return sensorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Sensor> findAllSensors() {
        return sensorRepository.findAll();
    }

    @Override
    public List<Sensor> getTopSensors() {
        return sensorRepository.getTopSensors().
                orElseThrow(() -> new RuntimeException("Top sensors not found"));
    }

    @Override
    public void saveSensor(Sensor sensor) {
        sensorRepository.save(sensor);
    }

    @Override
    public void updateSensor(Long id, Sensor sensor) {
        if (!id.equals(sensor.getId())) {
            throw new RuntimeException("id not match");
        }
        sensorRepository.saveAndFlush(sensor);
    }

    @Override
    public void deleteSensorById(Long id) {
        sensorRepository.deleteById(id);
    }
}
