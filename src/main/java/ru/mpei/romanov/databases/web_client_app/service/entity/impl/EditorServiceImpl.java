package ru.mpei.romanov.databases.web_client_app.service.entity.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mpei.romanov.databases.web_client_app.entity.Editor;
import org.springframework.transaction.annotation.Transactional;
import ru.mpei.romanov.databases.web_client_app.service.entity.EditorService;
import ru.mpei.romanov.databases.web_client_app.repository.entity.EditorRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class EditorServiceImpl implements EditorService {

    private final EditorRepository editorRepository;

    @Override
    public Optional<Editor> findEditorById(Long id) {
        return editorRepository.findById(id);
    }

    @Override
    public List<Editor> findAllEditors() {
        return editorRepository.findAll();
    }

    @Override
    public void addEditor(Editor editor) {
        editorRepository.insertEditor(editor.getLastName(), editor.getFirstName(), editor.getMiddleName(),
                editor.getPost(), editor.getPhoneNumber());
    }

    @Override
    public void updateEditor(Long id, Editor editor) {
        if (!id.equals(editor.getId())) {
            throw new RuntimeException("id not match");
        }
        editorRepository.updateEditor(id, editor.getLastName(), editor.getFirstName(),
                editor.getMiddleName(), editor.getPost(), editor.getPhoneNumber());
    }

    @Override
    public void deleteEditorById(Long id) {
        editorRepository.deleteEditorById(id);
    }
}
