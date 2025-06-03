package com.br.fiap.smartnature.dto;

import java.time.LocalDateTime;

public class LeituraAmbientalDTO {

    private Long id;
    private Long sensorId;
    private Double temperatura;
    private Double umidade;
    private Double fumacaPpm;
    private LocalDateTime dataHora;

    public LeituraAmbientalDTO() {
    }

    public LeituraAmbientalDTO(Long id, Long sensorId, Double temperatura, Double umidade, Double fumacaPpm, LocalDateTime dataHora) {
        this.id = id;
        this.sensorId = sensorId;
        this.temperatura = temperatura;
        this.umidade = umidade;
        this.fumacaPpm = fumacaPpm;
        this.dataHora = dataHora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSensorId() {
        return sensorId;
    }

    public void setSensorId(Long sensorId) {
        this.sensorId = sensorId;
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
