package ru.mpei.romanov.databases.web_client_app.service.dto.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mpei.romanov.databases.web_client_app.dto.response.UserResponseDto;
import ru.mpei.romanov.databases.web_client_app.entity.User;
import ru.mpei.romanov.databases.web_client_app.repository.entity.UserRepository;
import ru.mpei.romanov.databases.web_client_app.service.dto.UserDtoService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserDtoServiceImpl implements UserDtoService {

    private final UserRepository userRepository;

    @Override
    public List<UserResponseDto> getAllUsersDto() {
        List<User> users = userRepository.findAll();

        List<UserResponseDto> usersDto = new ArrayList<>();

        for (User user : users) {
            UserResponseDto userDto = new UserResponseDto(
                    user.getId(),
                    user.getUsername(),
                    String.join(", ", user.getRoles().stream()
                            .map(role -> role.getName().replace("ROLE_", "")).toList())
            );
            usersDto.add(userDto);
        }

        return usersDto;
    }
}
