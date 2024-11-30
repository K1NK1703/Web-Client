package ru.mpei.romanov.databases.web_client_app.service.entity.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mpei.romanov.databases.web_client_app.entity.event.Event;
import ru.mpei.romanov.databases.web_client_app.entity.sensor.Sensor;
import ru.mpei.romanov.databases.web_client_app.dto.request.EventRequestDto;
import ru.mpei.romanov.databases.web_client_app.entity.event.LoggingEvent;
import ru.mpei.romanov.databases.web_client_app.entity.event.PressureEvent;
import ru.mpei.romanov.databases.web_client_app.service.entity.EventService;
import ru.mpei.romanov.databases.web_client_app.entity.event.AirQualityEvent;
import ru.mpei.romanov.databases.web_client_app.service.entity.SensorService;
import ru.mpei.romanov.databases.web_client_app.entity.event.TemperatureEvent;
import ru.mpei.romanov.databases.web_client_app.entity.event.GasEmissionEvent;
import ru.mpei.romanov.databases.web_client_app.service.entity.LoggingEventService;
import ru.mpei.romanov.databases.web_client_app.service.entity.PressureEventService;
import ru.mpei.romanov.databases.web_client_app.service.entity.AirQualityEventService;
import ru.mpei.romanov.databases.web_client_app.service.entity.TemperatureEventService;
import ru.mpei.romanov.databases.web_client_app.service.entity.GasEmissionEventService;
import ru.mpei.romanov.databases.web_client_app.repository.entity.event.EventRepository;

import java.util.List;
import java.math.BigDecimal;

@Service
@Transactional
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final SensorService sensorService;
    private final EventRepository eventRepository;
    private final LoggingEventService loggingEventService;
    private final PressureEventService pressureEventService;
    private final AirQualityEventService airQualityEventService;
    private final TemperatureEventService temperatureEventService;
    private final GasEmissionEventService gasEmissionEventService;

    @Override
    public Event findEventById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    @Override
    public List<Event> findAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public void saveEvent(EventRequestDto eventRequestDto) {
        Event event = new Event();
        event.setTime(eventRequestDto.time());
        event = eventRepository.saveAndFlush(event);

        if (eventRequestDto.temperature() != null) {
            TemperatureEvent temperatureEvent = new TemperatureEvent();
            temperatureEvent.setTemperature(BigDecimal.valueOf(eventRequestDto.temperature()));
            temperatureEvent.setId(event.getId());
            temperatureEventService.saveTemperatureEvent(temperatureEvent);
        }

        if (eventRequestDto.pressure() != null) {
            PressureEvent pressureEvent = new PressureEvent();
            pressureEvent.setPressure(BigDecimal.valueOf(eventRequestDto.pressure()));
            pressureEvent.setId(event.getId());
            pressureEventService.savePressureEvent(pressureEvent);
        }

        if (eventRequestDto.gasEmission() != null) {
            GasEmissionEvent gasEmissionEvent = new GasEmissionEvent();
            gasEmissionEvent.setGasEmission(BigDecimal.valueOf(eventRequestDto.gasEmission()));
            gasEmissionEvent.setId(event.getId());
            gasEmissionEventService.saveGasEmissionEvent(gasEmissionEvent);
        }

        if (eventRequestDto.airQuality() != null) {
            AirQualityEvent airQualityEvent = new AirQualityEvent();
            airQualityEvent.setAirQuality(BigDecimal.valueOf(eventRequestDto.airQuality()));
            airQualityEvent.setId(event.getId());
            airQualityEventService.saveAirQualityEvent(airQualityEvent);
        }

        if (eventRequestDto.loggingLevel() != null) {
            LoggingEvent loggingEvent = new LoggingEvent();
            loggingEvent.setLoggingLevel(eventRequestDto.loggingLevel());
            loggingEvent.setId(event.getId());
            loggingEventService.saveLoggingEvent(loggingEvent);
        }

        Sensor sensor = sensorService.findSensorById(eventRequestDto.sensorId());
        if (sensor != null && !sensor.getEventId().equals(event.getId())) {
            sensor.setEventId(event.getId());
            sensorService.saveSensor(sensor);
        } else if (sensor != null) {
            sensorService.updateSensor(sensor.getId(), sensor);
        }
    }

    @Override
    public void updateEvent(Long id, Event event) {
        if (!id.equals(event.getId())) {
            throw new RuntimeException("id not match");
        }
        eventRepository.saveAndFlush(event);
    }

    @Override
    public void deleteEventById(Long id) {
        eventRepository.deleteById(id);
    }
}
