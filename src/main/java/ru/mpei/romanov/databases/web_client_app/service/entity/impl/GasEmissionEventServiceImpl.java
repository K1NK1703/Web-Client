package ru.mpei.romanov.databases.web_client_app.service.entity.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mpei.romanov.databases.web_client_app.entity.event.GasEmissionEvent;
import ru.mpei.romanov.databases.web_client_app.repository.entity.event.GasEmissionEventRepository;
import ru.mpei.romanov.databases.web_client_app.service.entity.GasEmissionEventService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class GasEmissionEventServiceImpl implements GasEmissionEventService {

    private final GasEmissionEventRepository gasEmissionEventRepository;

    @Override
    public Optional<GasEmissionEvent> findGasEmissionEventById(Long id) {
        return gasEmissionEventRepository.findById(id);
    }

    @Override
    public List<GasEmissionEvent> findAllGasEmissionEvents() {
        return gasEmissionEventRepository.findAll();
    }

    @Override
    public void saveGasEmissionEvent(GasEmissionEvent gasEmissionEvent) {
        gasEmissionEventRepository.save(gasEmissionEvent);
    }

    @Override
    public void updateGasEmissionEvent(GasEmissionEvent gasEmissionEvent) {
        gasEmissionEventRepository.saveAndFlush(gasEmissionEvent);
    }

    @Override
    public void deleteGasEmissionEventById(Long id) {
        gasEmissionEventRepository.deleteById(id);
    }
}
