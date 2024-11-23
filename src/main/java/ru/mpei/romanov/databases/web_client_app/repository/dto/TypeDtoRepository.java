package ru.mpei.romanov.databases.web_client_app.repository.dto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.mpei.romanov.databases.web_client_app.dto.response.TypeResponseDto;
import ru.mpei.romanov.databases.web_client_app.entity.sensor.Type;

import java.util.List;
import java.util.Optional;

public interface TypeDtoRepository extends JpaRepository<Type, Long> {

    @Query("""
            SELECT new ru.mpei.romanov.databases.web_client_app.dto.response.TypeResponseDto(
            t.id, t.name) FROM Type t
            """)
    Optional<List<TypeResponseDto>> getAllTypesDto();
}
