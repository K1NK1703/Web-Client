package ru.mpei.romanov.databases.web_client_app.repository.entity.event;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mpei.romanov.databases.web_client_app.entity.event.LoggingEvent;

import java.util.Optional;

public interface LoggingEventRepository extends JpaRepository<LoggingEvent, Long> {

    Optional<LoggingEvent> findByLoggingLevel(String loggingLevel);
}
