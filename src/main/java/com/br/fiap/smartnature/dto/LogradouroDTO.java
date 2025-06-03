package com.br.fiap.smartnature.dto;

public class LogradouroDTO {

    private Long id;
    private String descricao;
    private String cep;
    private Long cidadeId;

    public LogradouroDTO() {}

    public LogradouroDTO(Long id, String descricao, String cep, Long cidadeId) {
        this.id = id;
        this.descricao = descricao;
        this.cep = cep;
        this.cidadeId = cidadeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Long getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(Long cidadeId) {
        this.cidadeId = cidadeId;
    }
}
