package com.br.fiap.smartnature.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "T_GS_ALERTA")
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long alertaId;

    @ManyToOne
    @JoinColumn(name = "leitura_id", nullable = false)
    private LeituraAmbiental leituraAmbiental;

    @Column(length = 10)
    private String nivelSeveridade;

    @Column(length = 255)
    private String mensagem;

    @Column(length = 20)
    private String status;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    public Alerta() {}

    public Alerta(Long alertaId, LeituraAmbiental leituraAmbiental, String nivelSeveridade, String mensagem, String status, LocalDateTime dataCriacao) {
        this.alertaId = alertaId;
        this.leituraAmbiental = leituraAmbiental;
        this.nivelSeveridade = nivelSeveridade;
        this.mensagem = mensagem;
        this.status = status;
        this.dataCriacao = dataCriacao;
    }

    public Long getAlertaId() {
        return alertaId;
    }

    public void setAlertaId(Long alertaId) {
        this.alertaId = alertaId;
    }

    public LeituraAmbiental getLeituraAmbiental() {
        return leituraAmbiental;
    }

    public void setLeituraAmbiental(LeituraAmbiental leituraAmbiental) {
        this.leituraAmbiental = leituraAmbiental;
    }

    public String getNivelSeveridade() {
        return nivelSeveridade;
    }

    public void setNivelSeveridade(String nivelSeveridade) {
        this.nivelSeveridade = nivelSeveridade;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
