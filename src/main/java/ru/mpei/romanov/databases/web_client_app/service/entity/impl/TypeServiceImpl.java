package ru.mpei.romanov.databases.web_client_app.service.entity.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mpei.romanov.databases.web_client_app.entity.sensor.Type;
import ru.mpei.romanov.databases.web_client_app.repository.entity.sensor.TypeRepository;
import ru.mpei.romanov.databases.web_client_app.service.entity.TypeService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class TypeServiceImpl implements TypeService {

    private final TypeRepository typeRepository;

    @Override
    public Optional<Type> findTypeById(Long id) {
        return typeRepository.findById(id);
    }

    @Override
    public List<Type> findAllTypes() {
        return typeRepository.findAll();
    }

    @Override
    public void saveType(Type type) {
        typeRepository.save(type);
    }

    @Override
    public void updateType(Type type) {
        typeRepository.saveAndFlush(type);
    }

    @Override
    public void deleteTypeById(Long id) {
        typeRepository.deleteById(id);
    }
}
