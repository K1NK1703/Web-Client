package ru.mpei.romanov.databases.web_client_app.service.entity.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mpei.romanov.databases.web_client_app.entity.sensor.Sensor;
import ru.mpei.romanov.databases.web_client_app.repository.entity.sensor.SensorRepository;
import ru.mpei.romanov.databases.web_client_app.service.entity.SensorService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class SensorServiceImpl implements SensorService {

    private final SensorRepository sensorRepository;

    @Override
    public Optional<Sensor> findSensorById(Long id) {
        return sensorRepository.findById(id);
    }

    @Override
    public Optional<Sensor> findSensorByTypeIdAndInstallDate(Long typeId, LocalDate installDate) {
        return sensorRepository.findByTypeIdAndInstallDate(typeId, installDate);
    }

    @Override
    public Optional<Sensor> findSensorByEventIdAndLocation(Long eventId, String location) {
        return sensorRepository.findByEventIdAndLocation(eventId, location);
    }

    @Override
    public List<Sensor> findAllSensors() {
        return sensorRepository.findAll();
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
