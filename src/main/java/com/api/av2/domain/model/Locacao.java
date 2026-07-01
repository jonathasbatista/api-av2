package com.api.av2.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "locacoes")
@Data
public class Locacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataInicio;
    private boolean comMotorista;
    private boolean pagamentoAntecipado;
    private BigDecimal valorTotal;

    @Enumerated(EnumType.STRING)
    private PeriodoLocacao periodo;

    @ManyToOne
    @JoinColumn(name = "carro_id")
    private Carro carro;

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setComMotorista(boolean comMotorista) {
        this.comMotorista = comMotorista;
    }

    public void setPagamentoAntecipado(boolean pagamentoAntecipado) {
        this.pagamentoAntecipado = pagamentoAntecipado;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setPeriodo(PeriodoLocacao periodo) {
        this.periodo = periodo;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
}
