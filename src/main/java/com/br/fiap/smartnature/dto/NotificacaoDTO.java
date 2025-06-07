package com.br.fiap.smartnature.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

public class NotificacaoDTO {

    private Long id;

    @NotNull(message = "AlertaId é obrigatório")
    private Long alertaId;

    @NotNull(message = "UsuarioId é obrigatório")
    private Long usuarioId;

    private LocalDateTime dataEnvio;

    @NotBlank(message = "StatusEntrega é obrigatório")
    private String statusEntrega;


    public NotificacaoDTO(Long id, Long alertaId, Long usuarioId, LocalDateTime dataEnvio, String statusEntrega) {
        this.id = id;
        this.alertaId = alertaId;
        this.usuarioId = usuarioId;
        this.dataEnvio = dataEnvio;
        this.statusEntrega = statusEntrega;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getAlertaId() { return alertaId; }
    public void setAlertaId(Long alertaId) { this.alertaId = alertaId; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public LocalDateTime getDataEnvio() { return dataEnvio; }
    public void setDataEnvio(LocalDateTime dataEnvio) { this.dataEnvio = dataEnvio; }

    public String getStatusEntrega() { return statusEntrega; }
    public void setStatusEntrega(String statusEntrega) { this.statusEntrega = statusEntrega; }
}
