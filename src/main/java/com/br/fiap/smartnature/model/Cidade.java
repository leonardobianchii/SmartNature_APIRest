package com.br.fiap.smartnature.model;

import jakarta.persistence.*;

@Entity
@Table(name = "T_GS_CIDADE")
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cidadeId;

    @Column(nullable = false, length = 100)
    private String nome;

    public Cidade() {}

    public Cidade(Long cidadeId, String nome) {
        this.cidadeId = cidadeId;
        this.nome = nome;
    }

    public Long getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(Long cidadeId) {
        this.cidadeId = cidadeId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
