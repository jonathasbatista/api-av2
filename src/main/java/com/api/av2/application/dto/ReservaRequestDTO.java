package com.api.av2.application.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservaRequestDTO {
    private String canalOrigem;
    private LocalDate dataRetirada;
    private String periodo;
    private Long lojaRetiradaId;

    public String getCanalOrigem() {
        return canalOrigem;
    }

    public LocalDate getDataRetirada() {
        return dataRetirada;
    }

    public String getPeriodo() {
        return periodo;
    }

    public Long getLojaRetiradaId() {
        return lojaRetiradaId;
    }
}