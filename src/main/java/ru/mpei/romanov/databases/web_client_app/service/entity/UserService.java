package ru.mpei.romanov.databases.web_client_app.service.entity;

import ru.mpei.romanov.databases.web_client_app.entity.User;
import ru.mpei.romanov.databases.web_client_app.dto.request.UserRequestDto;

import java.util.Optional;

public interface UserService {

    Optional<User> findUserById(Long id);

    Optional<User> findUserByUsername(String username);

    void saveUser(UserRequestDto user);

    void updateUser(Long id, UserRequestDto user);

    void deleteUserById(Long id);
}
