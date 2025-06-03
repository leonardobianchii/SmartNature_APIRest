package com.br.fiap.smartnature.model;

import jakarta.persistence.*;

@Entity
@Table(name = "T_GS_SENSOR")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sensorId;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;

    @Column(length = 200)
    private String descricao;

    @Column(nullable = false, length = 1)
    private String statusAtivo;

    public Sensor() {
    }

    public Sensor(Long sensorId, Double latitude, Double longitude, String descricao, String statusAtivo) {
        this.sensorId = sensorId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.descricao = descricao;
        this.statusAtivo = statusAtivo;
    }

    public Long getSensorId() {
        return sensorId;
    }

    public void setSensorId(Long sensorId) {
        this.sensorId = sensorId;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatusAtivo() {
        return statusAtivo;
    }

    public void setStatusAtivo(String statusAtivo) {
        this.statusAtivo = statusAtivo;
    }
}
