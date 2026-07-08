package com.api.av2.application.dto;

import com.api.av2.domain.model.StatusCarro;
import lombok.Data;

@Data
public class CarroRequestDTO {
    private String placa;
    private String modelo;
    private String marca;
    private String tipo;
    private Double valorDiaria;
    private StatusCarro status;
    private Long lojaId;

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public StatusCarro getStatus() {
        return status;
    }

    public String getMarca() {
        return marca;
    }

    public Long getLojaId() {
        return lojaId;
    }

    public String getTipo() {return tipo;}

    public Double getValorDiaria() {return valorDiaria;}
}