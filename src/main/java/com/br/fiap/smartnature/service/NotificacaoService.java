package com.br.fiap.smartnature.service;

import com.br.fiap.smartnature.dto.NotificacaoDTO;
import com.br.fiap.smartnature.mapper.NotificacaoMapper;
import com.br.fiap.smartnature.model.Notificacao;
import com.br.fiap.smartnature.repository.NotificacaoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificacaoService {

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    @Autowired
    private NotificacaoMapper mapper;

    public NotificacaoDTO criar(NotificacaoDTO dto) {
        Notificacao notificacao = mapper.toEntity(dto);
        return mapper.toDTO(notificacaoRepository.save(notificacao));
    }

    public NotificacaoDTO buscarPorId(Long id) {
        Notificacao notificacao = notificacaoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Notificação não encontrada: " + id));
        return mapper.toDTO(notificacao);
    }

    public List<NotificacaoDTO> listarTodos() {
        return notificacaoRepository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public NotificacaoDTO atualizar(Long id, NotificacaoDTO dto) {
        Notificacao notificacao = notificacaoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Notificação não encontrada: " + id));

        notificacao.setAlerta(mapper.toEntity(dto).getAlerta());
        notificacao.setUsuario(mapper.toEntity(dto).getUsuario());
        notificacao.setDataEnvio(dto.getDataEnvio());
        notificacao.setStatusEntrega(dto.getStatusEntrega());

        return mapper.toDTO(notificacaoRepository.save(notificacao));
    }

    public void deletar(Long id) {
        Notificacao notificacao = notificacaoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Notificação não encontrada: " + id));
        notificacaoRepository.delete(notificacao);
    }
}
