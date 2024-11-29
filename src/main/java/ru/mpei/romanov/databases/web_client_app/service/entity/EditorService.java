package ru.mpei.romanov.databases.web_client_app.service.entity;

import ru.mpei.romanov.databases.web_client_app.entity.Editor;

import java.util.List;
import java.util.Optional;

public interface EditorService {

    Optional<Editor> findEditorById(Long id);

    List<Editor> findAllEditors();

    void addEditor(Editor editor);

    void updateEditor(Long id, Editor editor);

    void deleteEditorById(Long id);
}
