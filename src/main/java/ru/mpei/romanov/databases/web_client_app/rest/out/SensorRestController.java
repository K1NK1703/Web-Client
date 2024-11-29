package ru.mpei.romanov.databases.web_client_app.rest.out;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mpei.romanov.databases.web_client_app.entity.sensor.Sensor;
import ru.mpei.romanov.databases.web_client_app.exception.SensorNotFoundException;
import ru.mpei.romanov.databases.web_client_app.service.entity.SensorService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user/sensor")
public class SensorRestController {

    private final SensorService sensorService;

    @GetMapping
    public ResponseEntity<Sensor> getSensorById(@RequestParam("id") Long id) {
        Sensor sensor = sensorService.findSensorById(id)
                .orElseThrow(() -> new SensorNotFoundException("Sensor " + id + " not found!"));
        if (sensor != null) {
            return ResponseEntity.ok(sensor);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/sensors")
    public List<Sensor> getAllSensors() {
        return sensorService.findAllSensors();
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
