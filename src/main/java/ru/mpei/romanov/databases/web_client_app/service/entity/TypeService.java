package ru.mpei.romanov.databases.web_client_app.service.entity;

import ru.mpei.romanov.databases.web_client_app.entity.sensor.Type;

import java.util.List;

public interface TypeService {

    Type findTypeById(Long id);

    List<Type> findAllTypes();

    void saveType(Type type);

    void updateType(Long id, Type type);

    void deleteTypeById(Long id);
}
