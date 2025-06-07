package com.br.fiap.smartnature.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

public class LogAuditoriaDTO {

    private Long id;

    @NotBlank(message = "Descrição é obrigatória")
    @Size(max = 255, message = "Descrição deve ter no máximo 255 caracteres")
    private String descricao;

    private LocalDateTime dataHora;

    @NotNull(message = "UsuarioId é obrigatório")
    private Long usuarioId;

    
    public LogAuditoriaDTO(Long id, String descricao, LocalDateTime dataHora, Long usuarioId) {
        this.id = id;
        this.descricao = descricao;
        this.dataHora = dataHora;
        this.usuarioId = usuarioId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
}
