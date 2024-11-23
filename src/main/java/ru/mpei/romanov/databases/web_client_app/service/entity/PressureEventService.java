package ru.mpei.romanov.databases.web_client_app.service.entity;

import ru.mpei.romanov.databases.web_client_app.entity.event.PressureEvent;

import java.util.List;
import java.util.Optional;

public interface PressureEventService {

    Optional<PressureEvent> findPressureEventById(Long id);

    List<PressureEvent> findAllPressureEvents();

    void savePressureEvent(PressureEvent pressureEvent);

    void updatePressureEvent(PressureEvent pressureEvent);

    void deletePressureEventById(Long id);
}
