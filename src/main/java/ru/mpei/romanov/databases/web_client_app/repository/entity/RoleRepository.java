package ru.mpei.romanov.databases.web_client_app.repository.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.mpei.romanov.databases.web_client_app.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(String name);

    @Query("""
            SELECT r FROM Role r WHERE r.id in :id
            """)
    Optional<List<Role>> findRolesById(@Param("id") List<Long> id);

    @Query("""
            SELECT r FROM Role r WHERE r.name = :name
            """)
    Optional<Role> findRoleByName(@Param("name") String name);

    @Query("""
            SELECT r FROM Role r WHERE r.name IN :names
            """)
    Optional<List<Role>> findRolesByName(@Param("names") List<String> names);
}
