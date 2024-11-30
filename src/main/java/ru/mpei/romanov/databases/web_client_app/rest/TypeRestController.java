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
import ru.mpei.romanov.databases.web_client_app.entity.sensor.Type;
import ru.mpei.romanov.databases.web_client_app.service.entity.TypeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user/type")
public class TypeRestController {

    private final TypeService typeService;

    @GetMapping
    public ResponseEntity<Type> getTypeById(@RequestParam("id") Long id) {
        Type type = typeService.findTypeById(id);
        if (type != null) {
            return ResponseEntity.ok(type);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/types")
    public List<Type> getAllTypes() {
        return typeService.findAllTypes();
    }

    @PostMapping
    public ResponseEntity<Type> createType(@RequestBody Type type) {
        typeService.saveType(type);
        return ResponseEntity.ok(type);
    }

    @PutMapping
    public ResponseEntity<Type> updateType(@RequestParam("id") Long id, @RequestBody Type type) {
        typeService.updateType(id, type);
        return ResponseEntity.ok(type);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteType(@RequestParam("id") Long id) {
        typeService.deleteTypeById(id);
        return ResponseEntity.noContent().build();
    }
}
