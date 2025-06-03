package com.br.fiap.smartnature.mapper;

import com.br.fiap.smartnature.dto.NotificacaoDTO;
import com.br.fiap.smartnature.model.Alerta;
import com.br.fiap.smartnature.model.Notificacao;
import com.br.fiap.smartnature.model.Usuario;
import com.br.fiap.smartnature.repository.AlertaRepository;
import com.br.fiap.smartnature.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificacaoMapper {

    @Autowired
    private AlertaRepository alertaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public NotificacaoDTO toDTO(Notificacao notificacao) {
        return new NotificacaoDTO(
                notificacao.getNotificacaoId(),
                notificacao.getAlerta().getAlertaId(),
                notificacao.getUsuario().getUsuarioId(),
                notificacao.getDataEnvio(),
                notificacao.getStatusEntrega()
        );
    }

    public Notificacao toEntity(NotificacaoDTO dto) {
        Alerta alerta = alertaRepository.findById(dto.getAlertaId())
                .orElseThrow(() -> new IllegalArgumentException("Alerta não encontrado: " + dto.getAlertaId()));
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado: " + dto.getUsuarioId()));

        return new Notificacao(
                dto.getId(),
                alerta,
                usuario,
                dto.getDataEnvio(),
                dto.getStatusEntrega()
        );
    }
}
