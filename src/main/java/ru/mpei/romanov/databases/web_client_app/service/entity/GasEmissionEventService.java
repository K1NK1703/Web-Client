package ru.mpei.romanov.databases.web_client_app.service.entity;

import ru.mpei.romanov.databases.web_client_app.entity.event.GasEmissionEvent;

import java.util.List;
import java.util.Optional;

public interface GasEmissionEventService {

    Optional<GasEmissionEvent> findGasEmissionEventById(Long id);

    List<GasEmissionEvent> findAllGasEmissionEvents();

    void saveGasEmissionEvent(GasEmissionEvent gasEmissionEvent);

    void updateGasEmissionEvent(GasEmissionEvent gasEmissionEvent);

    void deleteGasEmissionEventById(Long id);
}
