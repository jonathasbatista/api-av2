package com.api.av2.application.dto;

import com.api.av2.domain.model.PeriodoLocacao;
import lombok.Data;

import java.time.LocalDate;

@Data
public class LocacaoRequestDTO {
    private Long lojaRetiradaId;
    private Long clienteId;
    private LocalDate dataInicio;
    private Boolean comMotorista;
    private Boolean pagamentoAntecipado;
    private PeriodoLocacao periodo;

    public Long getLojaId() {
        return lojaRetiradaId;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public boolean getComMotorista() {
        return comMotorista;
    }

    public PeriodoLocacao getPeriodo() {
        return periodo;
    }

    public Long getLojaRetiradaId() {return lojaRetiradaId;}

    public Long getClienteId() {return clienteId;}

    public Boolean getPagamentoAntecipado() {return pagamentoAntecipado;}
}
