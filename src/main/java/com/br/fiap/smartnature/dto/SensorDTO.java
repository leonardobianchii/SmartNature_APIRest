package com.br.fiap.smartnature.dto;

public class SensorDTO {

    private Long id;
    private Double latitude;
    private Double longitude;
    private String descricao;
    private String statusAtivo;

    public SensorDTO() {
    }

    public SensorDTO(Long id, Double latitude, Double longitude, String descricao, String statusAtivo) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.descricao = descricao;
        this.statusAtivo = statusAtivo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
