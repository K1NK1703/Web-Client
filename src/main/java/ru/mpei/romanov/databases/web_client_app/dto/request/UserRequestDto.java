package ru.mpei.romanov.databases.web_client_app.dto.request;

import java.util.List;

public record UserRequestDto(Long id,
                             String username,
                             String password,
                             List<String> roles) {
}