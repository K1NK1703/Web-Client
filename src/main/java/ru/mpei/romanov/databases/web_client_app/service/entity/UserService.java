package ru.mpei.romanov.databases.web_client_app.service.entity;

import ru.mpei.romanov.databases.web_client_app.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> findUserById(Long id);

    Optional<User> findUserByUsername(String username);

    List<User> findAllUsers();

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);
}
