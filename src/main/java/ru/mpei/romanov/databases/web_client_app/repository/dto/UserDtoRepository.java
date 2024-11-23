package ru.mpei.romanov.databases.web_client_app.repository.dto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.mpei.romanov.databases.web_client_app.dto.response.UserResponseDto;
import ru.mpei.romanov.databases.web_client_app.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDtoRepository extends JpaRepository<User, Long> {

    @Query("""
            SELECT new ru.mpei.romanov.databases.web_client_app.dto.response.UserResponseDto(
            u.id, u.username, r.name)
            FROM User u JOIN u.roles r""")
    Optional<List<UserResponseDto>> getAllUsersDto();
}
