package ru.mpei.romanov.databases.web_client_app.service.dto.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mpei.romanov.databases.web_client_app.dto.response.SensorResponseDto;
import ru.mpei.romanov.databases.web_client_app.repository.dto.SensorDtoRepository;
import ru.mpei.romanov.databases.web_client_app.service.dto.SensorDtoService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SensorDtoServiceImpl implements SensorDtoService {

    private final SensorDtoRepository sensorDtoRepository;

    @Override
    public List<SensorResponseDto> getAllSensorsDto() {
        return sensorDtoRepository.getAllSensorsDto()
                .orElseThrow(() -> new RuntimeException("No sensors found"));
    }
}
