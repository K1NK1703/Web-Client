package ru.mpei.romanov.databases.web_client_app.rest.out;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mpei.romanov.databases.web_client_app.entity.sensor.Type;
import ru.mpei.romanov.databases.web_client_app.exception.TypeNotFoundException;
import ru.mpei.romanov.databases.web_client_app.service.entity.TypeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user/type")
public class TypeRestController {

    private final TypeService typeService;

    @GetMapping
    public ResponseEntity<Type> getTypeById(@RequestParam("id") Long id) {
        Type type = typeService.findTypeById(id)
                .orElseThrow(() -> new TypeNotFoundException("Type " + id + " not found!"));
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
