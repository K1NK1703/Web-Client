package ru.mpei.romanov.databases.web_client_app.service.entity.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mpei.romanov.databases.web_client_app.entity.event.LoggingEvent;
import ru.mpei.romanov.databases.web_client_app.repository.entity.event.LoggingEventRepository;
import ru.mpei.romanov.databases.web_client_app.service.entity.LoggingEventService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class LoggingEventServiceImpl implements LoggingEventService {

    private final LoggingEventRepository loggingEventRepository;

    @Override
    public Optional<LoggingEvent> findLoggingEventById(Long id) {
        return loggingEventRepository.findById(id);
    }

    @Override
    public Optional<LoggingEvent> findLoggingEventByLoggingLevel(String loggingLevel) {
        return loggingEventRepository.findByLoggingLevel(loggingLevel);
    }

    @Override
    public List<LoggingEvent> findAllLoggingEvents() {
        return loggingEventRepository.findAll();
    }

    @Override
    public void saveLoggingEvent(LoggingEvent loggingEvent) {
        loggingEventRepository.save(loggingEvent);
    }

    @Override
    public void updateLoggingEvent(LoggingEvent loggingEvent) {
        loggingEventRepository.saveAndFlush(loggingEvent);
    }

    @Override
    public void deleteLoggingEventById(LoggingEvent loggingEvent) {
        loggingEventRepository.delete(loggingEvent);
    }
}
