package ru.mpei.romanov.databases.web_client_app.service.entity;

import ru.mpei.romanov.databases.web_client_app.entity.sensor.Factory;

import java.util.List;
import java.util.Optional;

public interface FactoryService {

    Optional<Factory> findFactoryById(Long id);

    Optional<Factory> findFactoryByName(String name);

    List<Factory> findAllFactories();

    void saveFactory(Factory factory);

    void updateFactory(Long id, Factory factory);

    void deleteFactoryById(Long id);
}
