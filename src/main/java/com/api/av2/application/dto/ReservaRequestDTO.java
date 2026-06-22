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

    public void setCanalOrigem(String canalOrigem) {
        this.canalOrigem = canalOrigem;
    }

    public LocalDate getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(LocalDate dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Long getLojaRetiradaId() {
        return lojaRetiradaId;
    }

    public void setLojaRetiradaId(Long lojaRetiradaId) {
        this.lojaRetiradaId = lojaRetiradaId;
    }
}