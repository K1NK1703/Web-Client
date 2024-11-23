package ru.mpei.romanov.databases.web_client_app.repository.entity.event;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mpei.romanov.databases.web_client_app.entity.event.Event;

import java.time.LocalDateTime;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Long> {

    Optional<Event> findByTime(LocalDateTime time);
}
