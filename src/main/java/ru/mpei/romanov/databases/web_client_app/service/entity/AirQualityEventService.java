package ru.mpei.romanov.databases.web_client_app.service.entity;

import ru.mpei.romanov.databases.web_client_app.entity.event.AirQualityEvent;

import java.util.List;
import java.util.Optional;

public interface AirQualityEventService {

    Optional<AirQualityEvent> findAirQualityEventById(Long id);

    List<AirQualityEvent> findAllAirQualityEvents();

    void saveAirQualityEvent(AirQualityEvent airQualityEvent);

    void updateAirQualityEvent(AirQualityEvent airQualityEvent);

    void deleteAirQualityEventById(Long id);
}
