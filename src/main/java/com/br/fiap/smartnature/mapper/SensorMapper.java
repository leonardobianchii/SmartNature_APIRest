package com.br.fiap.smartnature.mapper;

import com.br.fiap.smartnature.dto.SensorDTO;
import com.br.fiap.smartnature.model.Sensor;
import org.springframework.stereotype.Component;

@Component
public class SensorMapper {

    public SensorDTO toDTO(Sensor sensor) {
        return new SensorDTO(
                sensor.getSensorId(),
                sensor.getLatitude(),
                sensor.getLongitude(),
                sensor.getDescricao(),
                sensor.getStatusAtivo()
        );
    }

    public Sensor toEntity(SensorDTO dto) {
        return new Sensor(
                dto.getId(),
                dto.getLatitude(),
                dto.getLongitude(),
                dto.getDescricao(),
                dto.getStatusAtivo()
        );
    }
}
