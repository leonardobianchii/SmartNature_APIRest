package com.br.fiap.smartnature.service;

import com.br.fiap.smartnature.dto.SensorDTO;
import com.br.fiap.smartnature.mapper.SensorMapper;
import com.br.fiap.smartnature.model.Sensor;
import com.br.fiap.smartnature.repository.SensorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SensorService {

    @Autowired
    private SensorRepository sensorRepository;

    @Autowired
    private SensorMapper sensorMapper;

    public SensorDTO criar(SensorDTO dto) {
        Sensor sensor = sensorMapper.toEntity(dto);
        return sensorMapper.toDTO(sensorRepository.save(sensor));
    }

    public SensorDTO buscarPorId(Long id) {
        Sensor sensor = sensorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Sensor não encontrado: " + id));
        return sensorMapper.toDTO(sensor);
    }

    public List<SensorDTO> listarTodos() {
        return sensorRepository.findAll().stream()
                .map(sensorMapper::toDTO)
                .collect(Collectors.toList());
    }

    public SensorDTO atualizar(Long id, SensorDTO dto) {
        Sensor sensor = sensorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Sensor não encontrado: " + id));
        sensor.setLatitude(dto.getLatitude());
        sensor.setLongitude(dto.getLongitude());
        sensor.setDescricao(dto.getDescricao());
        sensor.setStatusAtivo(dto.getStatusAtivo());
        return sensorMapper.toDTO(sensorRepository.save(sensor));
    }

    public void deletar(Long id) {
        Sensor sensor = sensorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Sensor não encontrado: " + id));
        sensorRepository.delete(sensor);
    }
}
