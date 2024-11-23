package ru.mpei.romanov.databases.web_client_app.service.entity;

import ru.mpei.romanov.databases.web_client_app.entity.event.Event;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface EventService {

    Optional<Event> findEventById(Long id);

    Optional<Event> findEventByTime(LocalDateTime time);

    List<Event> findAllEvents();

    void saveEvent(Event event);

    void updateEvent(Event event);

    void deleteEventById(Long id);
}
