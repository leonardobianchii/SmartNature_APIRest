package com.br.fiap.smartnature.mapper;

import com.br.fiap.smartnature.dto.LogAuditoriaDTO;
import com.br.fiap.smartnature.model.LogAuditoria;
import com.br.fiap.smartnature.model.Usuario;
import com.br.fiap.smartnature.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogAuditoriaMapper {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public LogAuditoriaDTO toDTO(LogAuditoria entity) {
        return new LogAuditoriaDTO(
                entity.getLogId(),
                entity.getDescricao(),
                entity.getDataHora(),
                entity.getUsuario() != null ? entity.getUsuario().getUsuarioId() : null
        );
    }

    public LogAuditoria toEntity(LogAuditoriaDTO dto) {
        Usuario usuario = null;
        if (dto.getUsuarioId() != null) {
            usuario = usuarioRepository.findById(dto.getUsuarioId())
                    .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado: " + dto.getUsuarioId()));
        }

        return new LogAuditoria(
                dto.getId(),
                dto.getDescricao(),
                dto.getDataHora(),
                usuario
        );
    }
}
