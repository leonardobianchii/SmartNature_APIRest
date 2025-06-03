package com.br.fiap.smartnature.mapper;

import com.br.fiap.smartnature.dto.AlertaDTO;
import com.br.fiap.smartnature.model.Alerta;
import com.br.fiap.smartnature.model.LeituraAmbiental;
import com.br.fiap.smartnature.repository.LeituraAmbientalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AlertaMapper {

    @Autowired
    private LeituraAmbientalRepository leituraRepository;

    public AlertaDTO toDTO(Alerta alerta) {
        return new AlertaDTO(
                alerta.getAlertaId(),
                alerta.getLeituraAmbiental().getLeituraId(),
                alerta.getNivelSeveridade(),
                alerta.getMensagem(),
                alerta.getStatus(),
                alerta.getDataCriacao()
        );
    }

    public Alerta toEntity(AlertaDTO dto) {
        LeituraAmbiental leitura = leituraRepository.findById(dto.getLeituraId())
                .orElseThrow(() -> new IllegalArgumentException("Leitura não encontrada: " + dto.getLeituraId()));

        return new Alerta(
                dto.getId(),
                leitura,
                dto.getNivelSeveridade(),
                dto.getMensagem(),
                dto.getStatus(),
                dto.getDataCriacao()
        );
    }
}
