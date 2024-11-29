package ru.mpei.romanov.databases.web_client_app.repository.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.mpei.romanov.databases.web_client_app.entity.Editor;

public interface EditorRepository extends JpaRepository<Editor, Long> {

    @Modifying
    @Query(value = "CALL insert_editor(:lastName, :firstName, :middleName, :post, :phoneNumber)", nativeQuery = true)
    void insertEditor(String lastName, String firstName, String middleName, String post, String phoneNumber);

    @Modifying
    @Query(value = "CALL update_editor(cast(:id as INT), :lastName, :firstName, :middleName, :post, :phoneNumber)", nativeQuery = true)
    void updateEditor(Long id, String lastName, String firstName, String middleName, String post, String phoneNumber);

    @Modifying
    @Query(value = "CALL delete_editor(cast(:id as INT))", nativeQuery = true)
    void deleteEditorById(Long id);
}
