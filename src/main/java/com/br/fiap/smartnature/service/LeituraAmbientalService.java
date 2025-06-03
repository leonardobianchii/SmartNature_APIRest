package com.br.fiap.smartnature.service;

import com.br.fiap.smartnature.dto.LeituraAmbientalDTO;
import com.br.fiap.smartnature.mapper.LeituraAmbientalMapper;
import com.br.fiap.smartnature.model.LeituraAmbiental;
import com.br.fiap.smartnature.repository.LeituraAmbientalRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeituraAmbientalService {

    @Autowired
    private LeituraAmbientalRepository leituraRepository;

    @Autowired
    private LeituraAmbientalMapper mapper;

    public LeituraAmbientalDTO criar(LeituraAmbientalDTO dto) {
        LeituraAmbiental leitura = mapper.toEntity(dto);
        return mapper.toDTO(leituraRepository.save(leitura));
    }

    public LeituraAmbientalDTO buscarPorId(Long id) {
        LeituraAmbiental leitura = leituraRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Leitura não encontrada: " + id));
        return mapper.toDTO(leitura);
    }

    public List<LeituraAmbientalDTO> listarTodos() {
        return leituraRepository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public LeituraAmbientalDTO atualizar(Long id, LeituraAmbientalDTO dto) {
        LeituraAmbiental leitura = leituraRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Leitura não encontrada: " + id));

        leitura.setTemperatura(dto.getTemperatura());
        leitura.setUmidade(dto.getUmidade());
        leitura.setFumacaPpm(dto.getFumacaPpm());
        leitura.setDataHora(dto.getDataHora());
        leitura.setSensor(mapper.toEntity(dto).getSensor());

        return mapper.toDTO(leituraRepository.save(leitura));
    }

    public void deletar(Long id) {
        LeituraAmbiental leitura = leituraRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Leitura não encontrada: " + id));
        leituraRepository.delete(leitura);
    }
}
