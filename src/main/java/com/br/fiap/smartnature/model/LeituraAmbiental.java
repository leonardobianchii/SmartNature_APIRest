package com.br.fiap.smartnature.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "T_GS_LEITURA_AMBIENTAL")
public class LeituraAmbiental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leituraId;

    @ManyToOne
    @JoinColumn(name = "sensor_id", nullable = false)
    private Sensor sensor;

    private Double temperatura;
    private Double umidade;

    @Column(name = "fumaca_ppm")
    private Double fumacaPpm;

    @Column(name = "data_hora")
    private LocalDateTime dataHora;

    public LeituraAmbiental() {
    }

    public LeituraAmbiental(Long leituraId, Sensor sensor, Double temperatura, Double umidade, Double fumacaPpm, LocalDateTime dataHora) {
        this.leituraId = leituraId;
        this.sensor = sensor;
        this.temperatura = temperatura;
        this.umidade = umidade;
        this.fumacaPpm = fumacaPpm;
        this.dataHora = dataHora;
    }

    public Long getLeituraId() {
        return leituraId;
    }

    public void setLeituraId(Long leituraId) {
        this.leituraId = leituraId;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public Double getUmidade() {
        return umidade;
    }

    public void setUmidade(Double umidade) {
        this.umidade = umidade;
    }

    public Double getFumacaPpm() {
        return fumacaPpm;
    }

    public void setFumacaPpm(Double fumacaPpm) {
        this.fumacaPpm = fumacaPpm;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
