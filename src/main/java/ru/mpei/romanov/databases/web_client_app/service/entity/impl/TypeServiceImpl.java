package ru.mpei.romanov.databases.web_client_app.service.entity.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mpei.romanov.databases.web_client_app.entity.sensor.Type;
import ru.mpei.romanov.databases.web_client_app.service.entity.TypeService;
import ru.mpei.romanov.databases.web_client_app.repository.entity.sensor.TypeRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TypeServiceImpl implements TypeService {

    private final TypeRepository typeRepository;

    @Override
    public Type findTypeById(Long id) {
        return typeRepository.findById(id).orElse(null);
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
    public void updateType(Long id, Type type) {
        if (!id.equals(type.getId())) {
            throw new RuntimeException("Type id not match");
        }
        typeRepository.saveAndFlush(type);
    }

    @Override
    public void deleteTypeById(Long id) {
        typeRepository.deleteById(id);
    }
}
