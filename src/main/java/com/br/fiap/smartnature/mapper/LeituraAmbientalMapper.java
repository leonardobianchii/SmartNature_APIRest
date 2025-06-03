package com.br.fiap.smartnature.mapper;

import com.br.fiap.smartnature.dto.LeituraAmbientalDTO;
import com.br.fiap.smartnature.model.LeituraAmbiental;
import com.br.fiap.smartnature.model.Sensor;
import com.br.fiap.smartnature.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LeituraAmbientalMapper {

    @Autowired
    private SensorRepository sensorRepository;

    public LeituraAmbientalDTO toDTO(LeituraAmbiental leitura) {
        return new LeituraAmbientalDTO(
                leitura.getLeituraId(),
                leitura.getSensor().getSensorId(),
                leitura.getTemperatura(),
                leitura.getUmidade(),
                leitura.getFumacaPpm(),
                leitura.getDataHora()
        );
    }

    public LeituraAmbiental toEntity(LeituraAmbientalDTO dto) {
        Sensor sensor = sensorRepository.findById(dto.getSensorId())
                .orElseThrow(() -> new IllegalArgumentException("Sensor não encontrado: " + dto.getSensorId()));

        return new LeituraAmbiental(
                dto.getId(),
                sensor,
                dto.getTemperatura(),
                dto.getUmidade(),
                dto.getFumacaPpm(),
                dto.getDataHora()
        );
    }
}
