package ru.mpei.romanov.databases.web_client_app.repository.entity.event;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mpei.romanov.databases.web_client_app.entity.event.AirQualityEvent;

public interface AirQualityEventRepository extends JpaRepository<AirQualityEvent, Long> {
}
