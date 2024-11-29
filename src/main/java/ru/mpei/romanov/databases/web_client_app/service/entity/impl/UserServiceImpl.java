package ru.mpei.romanov.databases.web_client_app.service.entity.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mpei.romanov.databases.web_client_app.dto.request.UserRequestDto;
import ru.mpei.romanov.databases.web_client_app.entity.Role;
import ru.mpei.romanov.databases.web_client_app.entity.User;
import ru.mpei.romanov.databases.web_client_app.repository.entity.RoleRepository;
import ru.mpei.romanov.databases.web_client_app.repository.entity.UserRepository;
import ru.mpei.romanov.databases.web_client_app.service.entity.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(UserRequestDto user) {
        User newUser = new User();
        newUser.setUsername(user.username());
        newUser.setPassword(user.password());

        newUser.setRoles(checkAndSetAdminRole(user));

        if (user.id() == null) {
            newUser.setPassword(passwordEncoder.encode(user.password()));
            userRepository.saveAndFlush(newUser);
        } else {
            updateUser(user.id(), user);
        }
    }

    @Override
    public void updateUser(Long id, UserRequestDto user) {
        User newUser = userRepository.findById(id).orElse(null);

        if (newUser != null && id.equals(newUser.getId())) {
            newUser.setUsername(user.username());

            newUser.setRoles(checkAndSetAdminRole(user));

            if (user.password() != null && !user.password().isEmpty()) {
                newUser.setPassword(passwordEncoder.encode(user.password()));
            }

            userRepository.saveAndFlush(newUser);
        }
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    private List<Role> checkAndSetAdminRole(UserRequestDto user) {

        List<Role> roles = roleRepository.findRolesByName(user.roles()).orElse(new ArrayList<>());

        boolean hasAdminRole = roles.stream().anyMatch(role -> role.getName().equals("ROLE_ADMIN"));
        if (hasAdminRole) {
            Role userRole = roleRepository.findRoleByName("ROLE_USER").orElse(null);
            if (userRole != null && !roles.contains(userRole)) {
                roles.add(userRole);
            }
        }

        return roles;
    }
}
