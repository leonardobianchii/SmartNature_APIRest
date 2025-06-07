package com.br.fiap.smartnature.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

public class AlertaDTO {

    private Long id;

    @NotNull(message = "LeituraId é obrigatório")
    private Long leituraId;

    @NotBlank(message = "NivelSeveridade é obrigatório")
    private String nivelSeveridade;

    @NotBlank(message = "Mensagem é obrigatória")
    @Size(max = 255, message = "Mensagem deve ter no máximo 255 caracteres")
    private String mensagem;

    @NotBlank(message = "Status é obrigatório")
    private String status;

    private LocalDateTime dataCriacao;

    public AlertaDTO(Long id, Long leituraId, String nivelSeveridade, String mensagem, String status, LocalDateTime dataCriacao) {
        this.id = id;
        this.leituraId = leituraId;
        this.nivelSeveridade = nivelSeveridade;
        this.mensagem = mensagem;
        this.status = status;
        this.dataCriacao = dataCriacao;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getLeituraId() { return leituraId; }
    public void setLeituraId(Long leituraId) { this.leituraId = leituraId; }

    public String getNivelSeveridade() { return nivelSeveridade; }
    public void setNivelSeveridade(String nivelSeveridade) { this.nivelSeveridade = nivelSeveridade; }

    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(LocalDateTime dataCriacao) { this.dataCriacao = dataCriacao; }
}
