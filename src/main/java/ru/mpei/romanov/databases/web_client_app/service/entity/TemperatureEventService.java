package ru.mpei.romanov.databases.web_client_app.service.entity;

import ru.mpei.romanov.databases.web_client_app.entity.event.TemperatureEvent;

import java.util.List;
import java.util.Optional;

public interface TemperatureEventService {

    Optional<TemperatureEvent> findTemperatureEventById(Long id);

    List<TemperatureEvent> findAllTemperatureEvents();

    void saveTemperatureEvent(TemperatureEvent temperatureEvent);

    void updateTemperatureEvent(TemperatureEvent temperatureEvent);

    void deleteTemperatureEventById(Long id);
}
