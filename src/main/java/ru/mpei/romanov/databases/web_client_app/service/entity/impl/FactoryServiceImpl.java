package ru.mpei.romanov.databases.web_client_app.service.entity.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mpei.romanov.databases.web_client_app.entity.sensor.Factory;
import ru.mpei.romanov.databases.web_client_app.repository.entity.sensor.FactoryRepository;
import ru.mpei.romanov.databases.web_client_app.service.entity.FactoryService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class FactoryServiceImpl implements FactoryService {

    private final FactoryRepository factoryRepository;

    @Override
    public Optional<Factory> findFactoryById(Long id) {
        return factoryRepository.findById(id);
    }

    @Override
    public Optional<Factory> findFactoryByName(String name) {
        return factoryRepository.findByName(name);
    }

    @Override
    public List<Factory> findAllFactories() {
        return factoryRepository.findAll();
    }

    @Override
    public void saveFactory(Factory factory) {
        factoryRepository.save(factory);
    }

    @Override
    public void updateFactory(Factory factory) {
        factoryRepository.saveAndFlush(factory);
    }

    @Override
    public void deleteFactoryById(Long id) {
        factoryRepository.deleteById(id);
    }
}
