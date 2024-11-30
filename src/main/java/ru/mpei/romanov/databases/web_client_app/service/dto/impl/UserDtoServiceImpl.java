package ru.mpei.romanov.databases.web_client_app.service.dto.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mpei.romanov.databases.web_client_app.entity.User;
import org.springframework.transaction.annotation.Transactional;
import ru.mpei.romanov.databases.web_client_app.service.dto.UserDtoService;
import ru.mpei.romanov.databases.web_client_app.dto.response.UserResponseDto;
import ru.mpei.romanov.databases.web_client_app.repository.entity.UserRepository;

import java.util.List;
import java.util.ArrayList;

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
