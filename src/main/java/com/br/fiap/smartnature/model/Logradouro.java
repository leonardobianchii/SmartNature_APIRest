package com.br.fiap.smartnature.model;

import jakarta.persistence.*;

@Entity
@Table(name = "T_GS_LOGRADOURO")
public class Logradouro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logradouroId;

    @Column(nullable = false, length = 200)
    private String descricao;

    @Column(length = 10)
    private String cep;

    @ManyToOne
    @JoinColumn(name = "cidade_id", nullable = false)
    private Cidade cidade;

    public Logradouro() {}

    public Logradouro(Long logradouroId, String descricao, String cep, Cidade cidade) {
        this.logradouroId = logradouroId;
        this.descricao = descricao;
        this.cep = cep;
        this.cidade = cidade;
    }

    public Long getLogradouroId() {
        return logradouroId;
    }

    public void setLogradouroId(Long logradouroId) {
        this.logradouroId = logradouroId;
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

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}
