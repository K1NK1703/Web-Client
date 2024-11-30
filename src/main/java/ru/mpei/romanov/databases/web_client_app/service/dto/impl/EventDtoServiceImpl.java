package ru.mpei.romanov.databases.web_client_app.service.dto.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mpei.romanov.databases.web_client_app.service.dto.EventDtoService;
import ru.mpei.romanov.databases.web_client_app.repository.dto.EventDtoRepository;
import ru.mpei.romanov.databases.web_client_app.dto.response.FactorySensorEventResponseDto;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EventDtoServiceImpl implements EventDtoService {

    private final EventDtoRepository eventDtoRepository;

    @Override
    public List<FactorySensorEventResponseDto> getSensorEventsDto() {
        return eventDtoRepository.getSensorEventsDto();
    }
}
