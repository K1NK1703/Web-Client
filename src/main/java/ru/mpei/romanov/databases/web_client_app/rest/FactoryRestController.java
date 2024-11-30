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
import ru.mpei.romanov.databases.web_client_app.entity.sensor.Factory;
import ru.mpei.romanov.databases.web_client_app.service.entity.FactoryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user/factory")
public class FactoryRestController {

    private final FactoryService factoryService;

    @GetMapping
    public ResponseEntity<Factory> getFactory(@RequestParam("id") Long id) {
        Factory factory = factoryService.findFactoryById(id);
        if (factory != null) {
            return ResponseEntity.ok(factory);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/factories")
    public List<Factory> getAllFactories() {
        return factoryService.findAllFactories();
    }

    @PostMapping
    public ResponseEntity<Factory> createFactory(@RequestBody Factory factory) {
        factoryService.saveFactory(factory);
        return ResponseEntity.ok(factory);
    }

    @PutMapping
    public ResponseEntity<Factory> updateFactory(@RequestParam("id") Long id, @RequestBody Factory factory) {
        factoryService.updateFactory(id, factory);
        return ResponseEntity.ok(factory);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteFactory(@RequestParam("id") Long id) {
        factoryService.deleteFactoryById(id);
        return ResponseEntity.noContent().build();
    }
}
