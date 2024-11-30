package ru.mpei.romanov.databases.web_client_app.service.entity;

import ru.mpei.romanov.databases.web_client_app.entity.sensor.Factory;

import java.util.List;

public interface FactoryService {

    Factory findFactoryById(Long id);

    List<Factory> findAllFactories();

    String getLongestFactoryName();

    void saveFactory(Factory factory);

    void updateFactory(Long id, Factory factory);

    void deleteFactoryById(Long id);
}
