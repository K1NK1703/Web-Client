package ru.mpei.romanov.databases.web_client_app.service.dto.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mpei.romanov.databases.web_client_app.dto.response.TypeResponseDto;
import ru.mpei.romanov.databases.web_client_app.repository.dto.TypeDtoRepository;
import ru.mpei.romanov.databases.web_client_app.service.dto.TypeDtoService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TypeDtoServiceImpl implements TypeDtoService {

    private final TypeDtoRepository typeDtoRepository;

    @Override
    public List<TypeResponseDto> getAllTypesDto() {
        return typeDtoRepository.getAllTypesDto().
                orElseThrow(() -> new RuntimeException("No types found"));
    }
}
