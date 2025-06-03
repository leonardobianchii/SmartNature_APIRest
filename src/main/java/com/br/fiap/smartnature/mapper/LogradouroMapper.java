package com.br.fiap.smartnature.mapper;

import com.br.fiap.smartnature.dto.LogradouroDTO;
import com.br.fiap.smartnature.model.Cidade;
import com.br.fiap.smartnature.model.Logradouro;
import com.br.fiap.smartnature.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogradouroMapper {

    @Autowired
    private CidadeRepository cidadeRepository;

    public LogradouroDTO toDTO(Logradouro entity) {
        return new LogradouroDTO(
                entity.getLogradouroId(),
                entity.getDescricao(),
                entity.getCep(),
                entity.getCidade().getCidadeId()
        );
    }

    public Logradouro toEntity(LogradouroDTO dto) {
        Cidade cidade = cidadeRepository.findById(dto.getCidadeId())
                .orElseThrow(() -> new IllegalArgumentException("Cidade não encontrada: " + dto.getCidadeId()));
        return new Logradouro(
                dto.getId(),
                dto.getDescricao(),
                dto.getCep(),
                cidade
        );
    }
}
