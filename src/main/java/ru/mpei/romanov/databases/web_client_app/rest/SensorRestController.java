package ru.mpei.romanov.databases.web_client_app.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mpei.romanov.databases.web_client_app.entity.sensor.Sensor;
import ru.mpei.romanov.databases.web_client_app.service.dto.EventDtoService;
import ru.mpei.romanov.databases.web_client_app.service.entity.SensorService;
import ru.mpei.romanov.databases.web_client_app.service.entity.FactoryService;
import ru.mpei.romanov.databases.web_client_app.dto.response.FactorySensorEventResponseDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user/sensor")
public class SensorRestController {

    private final SensorService sensorService;
    private final FactoryService factoryService;
    private final EventDtoService eventDtoService;

    @GetMapping
    public ResponseEntity<Sensor> getSensorById(@RequestParam("id") Long id) {
        Sensor sensor = sensorService.findSensorById(id);
        if (sensor != null) {
            return ResponseEntity.ok(sensor);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/sensors")
    public List<Sensor> getAllSensors() {
        return sensorService.findAllSensors();
    }

    @GetMapping("/events")
    public List<FactorySensorEventResponseDto> getSensorEvents() {
        return eventDtoService.getSensorEventsDto();
    }

    @GetMapping("/sensors/top")
    public List<Sensor> getTopSensors() {
        return sensorService.getTopSensors();
    }

    @GetMapping("/factory/name")
    public String getLongestFactoryName() {
        return factoryService.getLongestFactoryName();
    }

    @PostMapping
    public ResponseEntity<Sensor> createSensor(@RequestBody Sensor sensor) {
        sensorService.saveSensor(sensor);
        return ResponseEntity.ok(sensor);
    }

    @PutMapping
    public ResponseEntity<Sensor> updateSensor(@RequestParam("id") Long id, @RequestBody Sensor sensor) {
        sensorService.updateSensor(id, sensor);
        return ResponseEntity.ok(sensor);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteSensor(@RequestParam("id") Long id) {
        sensorService.deleteSensorById(id);
        return ResponseEntity.noContent().build();
    }
}
