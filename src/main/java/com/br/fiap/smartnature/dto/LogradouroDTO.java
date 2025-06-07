package com.br.fiap.smartnature.dto;

import jakarta.validation.constraints.*;

public class LogradouroDTO {

    private Long id;

    @NotBlank(message = "Descrição é obrigatória")
    private String descricao;

    @NotBlank(message = "CEP é obrigatório")
    private String cep;

    @NotNull(message = "CidadeId é obrigatório")
    private Long cidadeId;


    public LogradouroDTO(Long id, String descricao, String cep, Long cidadeId) {
        this.id = id;
        this.descricao = descricao;
        this.cep = cep;
        this.cidadeId = cidadeId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }

    public Long getCidadeId() { return cidadeId; }
    public void setCidadeId(Long cidadeId) { this.cidadeId = cidadeId; }
}
