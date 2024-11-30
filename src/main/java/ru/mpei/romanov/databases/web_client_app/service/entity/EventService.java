package ru.mpei.romanov.databases.web_client_app.service.entity;

import ru.mpei.romanov.databases.web_client_app.entity.event.Event;
import ru.mpei.romanov.databases.web_client_app.dto.request.EventRequestDto;

import java.util.List;

public interface EventService {

    Event findEventById(Long id);

    List<Event> findAllEvents();

    void saveEvent(EventRequestDto eventRequestDto);

    void updateEvent(Long id, Event event);

    void deleteEventById(Long id);
}
