package com.api.av2.application.dto;

import lombok.Data;

@Data
public class CarroRequestDTO {
    private String placa;
    private String modelo;
    private String marca;
    private String status;
    private Long lojaId;

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public String getStatus() {
        return status;
    }

    public String getMarca() {
        return marca;
    }

    public Long getLojaId() {
        return lojaId;
    }
}