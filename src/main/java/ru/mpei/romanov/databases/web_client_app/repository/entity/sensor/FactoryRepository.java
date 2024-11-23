package ru.mpei.romanov.databases.web_client_app.repository.entity.sensor;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mpei.romanov.databases.web_client_app.entity.sensor.Factory;

import java.util.Optional;

public interface FactoryRepository extends JpaRepository<Factory, Long> {

    Optional<Factory> findByName(String name);
}
