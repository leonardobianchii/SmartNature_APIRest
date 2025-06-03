package com.br.fiap.smartnature.service;

import com.br.fiap.smartnature.dto.LogradouroDTO;
import com.br.fiap.smartnature.mapper.LogradouroMapper;
import com.br.fiap.smartnature.model.Logradouro;
import com.br.fiap.smartnature.repository.LogradouroRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LogradouroService {

    @Autowired
    private LogradouroRepository repository;

    @Autowired
    private LogradouroMapper mapper;

    public LogradouroDTO criar(LogradouroDTO dto) {
        Logradouro entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    public LogradouroDTO buscarPorId(Long id) {
        Logradouro entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Logradouro não encontrado: " + id));
        return mapper.toDTO(entity);
    }

    public List<LogradouroDTO> listarTodos() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public LogradouroDTO atualizar(Long id, LogradouroDTO dto) {
        Logradouro entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Logradouro não encontrado: " + id));

        entity.setDescricao(dto.getDescricao());
        entity.setCep(dto.getCep());
        entity.setCidade(mapper.toEntity(dto).getCidade());

        return mapper.toDTO(repository.save(entity));
    }

    public void deletar(Long id) {
        Logradouro entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Logradouro não encontrado: " + id));
        repository.delete(entity);
    }
}
