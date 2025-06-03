package com.br.fiap.smartnature.mapper;

import com.br.fiap.smartnature.dto.UsuarioDTO;
import com.br.fiap.smartnature.model.Logradouro;
import com.br.fiap.smartnature.model.Usuario;
import com.br.fiap.smartnature.repository.LogradouroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    @Autowired
    private LogradouroRepository logradouroRepository;

    public UsuarioDTO toDTO(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getUsuarioId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTelefone(),
                usuario.getTipo(),
                usuario.getLogradouro().getLogradouroId()
        );
    }

    public Usuario toEntity(UsuarioDTO dto) {
        Logradouro logradouro = logradouroRepository.findById(dto.getLogradouroId())
                .orElseThrow(() -> new IllegalArgumentException("Logradouro não encontrado: " + dto.getLogradouroId()));
        return new Usuario(
                dto.getId(),
                dto.getNome(),
                dto.getEmail(),
                dto.getTelefone(),
                dto.getTipo(),
                logradouro
        );
    }
}
