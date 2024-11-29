package ru.mpei.romanov.databases.web_client_app.rest.out;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mpei.romanov.databases.web_client_app.entity.Editor;
import ru.mpei.romanov.databases.web_client_app.service.entity.EditorService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/editor")
public class EditorRestController {

    private final EditorService editorService;

    @GetMapping
    public ResponseEntity<Editor> getEditorById(@RequestParam("id") Long id) {
        Editor editor = editorService.findEditorById(id)
                .orElseThrow(() -> new RuntimeException("editor not found"));
        if (editor != null) {
            return ResponseEntity.ok(editor);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/editors")
    public List<Editor> getAllEditors() {
        return editorService.findAllEditors();
    }

    @PostMapping
    public ResponseEntity<Editor> createEditor(@RequestBody Editor editor) {
        editorService.addEditor(editor);
        return ResponseEntity.ok(editor);
    }

    @PutMapping
    public ResponseEntity<Editor> updateEditor(@RequestParam("id") Long id, @RequestBody Editor editor) {
        editorService.updateEditor(id, editor);
        return ResponseEntity.ok(editor);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteEditor(@RequestParam("id") Long id) {
        editorService.deleteEditorById(id);
        return ResponseEntity.noContent().build();
    }
}
