package ru.mpei.romanov.databases.web_client_app.service.dto.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mpei.romanov.databases.web_client_app.dto.response.UserResponseDto;
import ru.mpei.romanov.databases.web_client_app.repository.dto.UserDtoRepository;
import ru.mpei.romanov.databases.web_client_app.service.dto.UserDtoService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserDtoServiceImpl implements UserDtoService {

    private final UserDtoRepository userDtoRepository;

    @Override
    public List<UserResponseDto> getAllUsersDto() {
        return userDtoRepository.getAllUsersDto()
                .orElseThrow(() -> new RuntimeException("No users found"));
    }
}
