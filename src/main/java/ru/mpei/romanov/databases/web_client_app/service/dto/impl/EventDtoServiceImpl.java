package ru.mpei.romanov.databases.web_client_app.service.dto.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mpei.romanov.databases.web_client_app.dto.response.EventResponseDto;
import ru.mpei.romanov.databases.web_client_app.dto.response.FactorySensorEventDto;
import ru.mpei.romanov.databases.web_client_app.repository.dto.EventDtoRepository;
import ru.mpei.romanov.databases.web_client_app.service.dto.EventDtoService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EventDtoServiceImpl implements EventDtoService {

    private final EventDtoRepository eventDtoRepository;

    @Override
    public EventResponseDto getEventDtoById(Long id) {
        return eventDtoRepository.getEventDtoById(id)
                .orElseThrow(() -> new RuntimeException("No event found"));
    }

    @Override
    public List<EventResponseDto> getAllEventsDto() {
        return eventDtoRepository.getAllEventsDto().
                orElseThrow(() -> new RuntimeException("No events found"));
    }

    @Override
    public List<FactorySensorEventDto> getSensorEvents() {
        return eventDtoRepository.getSensorEvents().
                orElseThrow(() -> new RuntimeException("No data found"));
    }
}
