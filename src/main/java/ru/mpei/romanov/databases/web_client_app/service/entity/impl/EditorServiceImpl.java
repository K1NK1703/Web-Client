package ru.mpei.romanov.databases.web_client_app.service.entity.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mpei.romanov.databases.web_client_app.entity.Editor;
import ru.mpei.romanov.databases.web_client_app.repository.entity.EditorRepository;
import ru.mpei.romanov.databases.web_client_app.service.entity.EditorService;

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
    public void updateEditor(Editor editor) {
        editorRepository.updateEditor(editor.getId(), editor.getLastName(), editor.getFirstName(),
                editor.getMiddleName(), editor.getPost(), editor.getPhoneNumber());
    }

    @Override
    public void deleteEditorById(Long id) {
        editorRepository.deleteEditorById(id);
    }
}
