package ru.mpei.romanov.databases.web_client_app.service.entity.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mpei.romanov.databases.web_client_app.entity.event.AirQualityEvent;
import ru.mpei.romanov.databases.web_client_app.repository.entity.event.AirQualityEventRepository;
import ru.mpei.romanov.databases.web_client_app.service.entity.AirQualityEventService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AirQualityEventServiceImpl implements AirQualityEventService {

    private final AirQualityEventRepository airQualityEventRepository;

    @Override
    public Optional<AirQualityEvent> findAirQualityEventById(Long id) {
        return airQualityEventRepository.findById(id);
    }

    @Override
    public List<AirQualityEvent> findAllAirQualityEvents() {
        return airQualityEventRepository.findAll();
    }

    @Override
    public void saveAirQualityEvent(AirQualityEvent airQualityEvent) {
        airQualityEventRepository.save(airQualityEvent);
    }

    @Override
    public void updateAirQualityEvent(AirQualityEvent airQualityEvent) {
        airQualityEventRepository.saveAndFlush(airQualityEvent);
    }

    @Override
    public void deleteAirQualityEventById(Long id) {
        airQualityEventRepository.deleteById(id);
    }
}
