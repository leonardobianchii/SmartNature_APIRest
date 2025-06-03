package com.br.fiap.smartnature.service;

import com.br.fiap.smartnature.dto.AlertaDTO;
import com.br.fiap.smartnature.mapper.AlertaMapper;
import com.br.fiap.smartnature.model.Alerta;
import com.br.fiap.smartnature.repository.AlertaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlertaService {

    @Autowired
    private AlertaRepository alertaRepository;

    @Autowired
    private AlertaMapper alertaMapper;

    public AlertaDTO criar(AlertaDTO dto) {
        Alerta alerta = alertaMapper.toEntity(dto);
        return alertaMapper.toDTO(alertaRepository.save(alerta));
    }

    public AlertaDTO buscarPorId(Long id) {
        Alerta alerta = alertaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Alerta não encontrado: " + id));
        return alertaMapper.toDTO(alerta);
    }

    public List<AlertaDTO> listarTodos() {
        return alertaRepository.findAll().stream()
                .map(alertaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public AlertaDTO atualizar(Long id, AlertaDTO dto) {
        Alerta alerta = alertaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Alerta não encontrado: " + id));

        alerta.setNivelSeveridade(dto.getNivelSeveridade());
        alerta.setMensagem(dto.getMensagem());
        alerta.setStatus(dto.getStatus());
        alerta.setDataCriacao(dto.getDataCriacao());
        alerta.setLeituraAmbiental(alertaMapper.toEntity(dto).getLeituraAmbiental());

        return alertaMapper.toDTO(alertaRepository.save(alerta));
    }

    public void deletar(Long id) {
        Alerta alerta = alertaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Alerta não encontrado: " + id));
        alertaRepository.delete(alerta);
    }
}
