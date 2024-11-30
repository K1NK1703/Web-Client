package ru.mpei.romanov.databases.web_client_app.service.entity.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mpei.romanov.databases.web_client_app.entity.event.TemperatureEvent;
import ru.mpei.romanov.databases.web_client_app.service.entity.TemperatureEventService;
import ru.mpei.romanov.databases.web_client_app.repository.entity.event.TemperatureEventRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class TemperatureEventServiceImpl implements TemperatureEventService {

    private final TemperatureEventRepository temperatureEventRepository;

    @Override
    public Optional<TemperatureEvent> findTemperatureEventById(Long id) {
        return temperatureEventRepository.findById(id);
    }

    @Override
    public List<TemperatureEvent> findAllTemperatureEvents() {
        return temperatureEventRepository.findAll();
    }

    @Override
    public void saveTemperatureEvent(TemperatureEvent temperatureEvent) {
        temperatureEventRepository.save(temperatureEvent);
    }

    @Override
    public void updateTemperatureEvent(TemperatureEvent temperatureEvent) {
        temperatureEventRepository.saveAndFlush(temperatureEvent);
    }

    @Override
    public void deleteTemperatureEventById(Long id) {
        temperatureEventRepository.deleteById(id);
    }
}
