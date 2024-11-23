package ru.mpei.romanov.databases.web_client_app.service.entity;

import ru.mpei.romanov.databases.web_client_app.entity.event.LoggingEvent;

import java.util.List;
import java.util.Optional;

public interface LoggingEventService {

    Optional<LoggingEvent> findLoggingEventById(Long id);

    Optional<LoggingEvent> findLoggingEventByLoggingLevel(String loggingLevel);

    List<LoggingEvent> findAllLoggingEvents();

    void saveLoggingEvent(LoggingEvent loggingEvent);

    void updateLoggingEvent(LoggingEvent loggingEvent);

    void deleteLoggingEventById(LoggingEvent loggingEvent);
}
