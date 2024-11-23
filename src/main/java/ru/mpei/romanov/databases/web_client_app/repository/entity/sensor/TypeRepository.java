package ru.mpei.romanov.databases.web_client_app.repository.entity.sensor;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mpei.romanov.databases.web_client_app.entity.sensor.Type;

public interface TypeRepository extends JpaRepository<Type, Long> {
}
