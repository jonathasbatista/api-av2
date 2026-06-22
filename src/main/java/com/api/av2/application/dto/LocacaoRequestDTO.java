package com.api.av2.application.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LocacaoRequestDTO {
    private Long lojaId;
    private LocalDate dataInicio;
    private boolean comMotorista;
    private String periodo;

    public Long getLojaId() {
        return lojaId;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public boolean getComMotorista() {
        return comMotorista;
    }

    public String getPeriodo() {
        return periodo;
    }
}
