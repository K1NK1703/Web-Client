package ru.mpei.romanov.databases.web_client_app.service.entity.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mpei.romanov.databases.web_client_app.entity.sensor.Factory;
import ru.mpei.romanov.databases.web_client_app.service.entity.FactoryService;
import ru.mpei.romanov.databases.web_client_app.repository.entity.sensor.FactoryRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class FactoryServiceImpl implements FactoryService {

    private final FactoryRepository factoryRepository;

    @Override
    public Factory findFactoryById(Long id) {
        return factoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Factory> findAllFactories() {
        return factoryRepository.findAll();
    }

    @Override
    public String getLongestFactoryName() {
        return factoryRepository.getLongestFactoryName()
                .orElseThrow(() -> new RuntimeException("Longest factory name not found"));
    }

    @Override
    public void saveFactory(Factory factory) {
        factoryRepository.save(factory);
    }

    @Override
    public void updateFactory(Long id, Factory factory) {
        if (!id.equals(factory.getId())) {
            throw new RuntimeException("id not match");
        }
        factoryRepository.saveAndFlush(factory);
    }

    @Override
    public void deleteFactoryById(Long id) {
        factoryRepository.deleteById(id);
    }
}
