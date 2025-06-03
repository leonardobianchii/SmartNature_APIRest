package com.br.fiap.smartnature.service;

import com.br.fiap.smartnature.dto.LogAuditoriaDTO;
import com.br.fiap.smartnature.mapper.LogAuditoriaMapper;
import com.br.fiap.smartnature.model.LogAuditoria;
import com.br.fiap.smartnature.repository.LogAuditoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LogAuditoriaService {

    @Autowired
    private LogAuditoriaRepository repository;

    @Autowired
    private LogAuditoriaMapper mapper;

    public LogAuditoriaDTO criar(LogAuditoriaDTO dto) {
        LogAuditoria log = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(log));
    }

    public LogAuditoriaDTO buscarPorId(Long id) {
        LogAuditoria log = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Log não encontrado: " + id));
        return mapper.toDTO(log);
    }

    public List<LogAuditoriaDTO> listarTodos() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public LogAuditoriaDTO atualizar(Long id, LogAuditoriaDTO dto) {
        LogAuditoria log = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Log não encontrado: " + id));
        log.setDescricao(dto.getDescricao());
        log.setDataHora(dto.getDataHora());
        log.setUsuario(mapper.toEntity(dto).getUsuario());
        return mapper.toDTO(repository.save(log));
    }

    public void deletar(Long id) {
        LogAuditoria log = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Log não encontrado: " + id));
        repository.delete(log);
    }
}
