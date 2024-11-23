package ru.mpei.romanov.databases.web_client_app.rest.out;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mpei.romanov.databases.web_client_app.dto.response.SensorResponseDto;
import ru.mpei.romanov.databases.web_client_app.dto.response.TypeResponseDto;
import ru.mpei.romanov.databases.web_client_app.entity.sensor.Factory;
import ru.mpei.romanov.databases.web_client_app.entity.sensor.Sensor;
import ru.mpei.romanov.databases.web_client_app.exception.SensorNotFoundException;
import ru.mpei.romanov.databases.web_client_app.service.dto.SensorDtoService;
import ru.mpei.romanov.databases.web_client_app.service.dto.TypeDtoService;
import ru.mpei.romanov.databases.web_client_app.service.entity.FactoryService;
import ru.mpei.romanov.databases.web_client_app.service.entity.SensorService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user/sensor")
public class SensorRestController {

    private final TypeDtoService typeDtoService;
    private final SensorService sensorService;
    private final FactoryService factoryService;
    private final SensorDtoService sensorDtoService;

    @GetMapping("/sensors")
    public List<SensorResponseDto> getAllSensors() {
        return sensorDtoService.getAllSensorsDto();
    }

    @GetMapping
    public ResponseEntity<Sensor> getSensor(@RequestParam("id") Long id) {
        Sensor sensor = sensorService.findSensorById(id)
                .orElseThrow(() -> new SensorNotFoundException("Sensor " + id + " not found!"));
        if (sensor != null) {
            return ResponseEntity.ok(sensor);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    public ResponseEntity<Sensor> createSensor(@RequestBody Sensor sensor) {
        sensorService.saveSensor(sensor);
        return ResponseEntity.ok(sensor);
    }

    @PutMapping("/update")
    public ResponseEntity<Sensor> updateSensor(@RequestBody Sensor sensor) {
        sensorService.updateSensor(sensor);
        return ResponseEntity.ok(sensor);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteSensor(@RequestParam("id") Long id) {
        sensorService.deleteSensorById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/types")
    public List<TypeResponseDto> getAllTypes() {
        return typeDtoService.getAllTypesDto();
    }

    @GetMapping("/factories")
    public List<Factory> getAllFactories() {
        return factoryService.findAllFactories();
    }
}
