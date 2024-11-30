package ru.mpei.romanov.databases.web_client_app.service.entity.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mpei.romanov.databases.web_client_app.entity.event.PressureEvent;
import ru.mpei.romanov.databases.web_client_app.service.entity.PressureEventService;
import ru.mpei.romanov.databases.web_client_app.repository.entity.event.PressureEventRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PressureEventServiceImpl implements PressureEventService {

    private final PressureEventRepository pressureEventRepository;

    @Override
    public Optional<PressureEvent> findPressureEventById(Long id) {
        return pressureEventRepository.findById(id);
    }

    @Override
    public List<PressureEvent> findAllPressureEvents() {
        return pressureEventRepository.findAll();
    }

    @Override
    public void savePressureEvent(PressureEvent pressureEvent) {
        pressureEventRepository.save(pressureEvent);
    }

    @Override
    public void updatePressureEvent(PressureEvent pressureEvent) {
        pressureEventRepository.saveAndFlush(pressureEvent);
    }

    @Override
    public void deletePressureEventById(Long id) {
        pressureEventRepository.deleteById(id);
    }
}
