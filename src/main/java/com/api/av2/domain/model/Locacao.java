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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public boolean isComMotorista() {
        return comMotorista;
    }

    public void setComMotorista(boolean comMotorista) {
        this.comMotorista = comMotorista;
    }

    public boolean isPagamentoAntecipado() {
        return pagamentoAntecipado;
    }

    public void setPagamentoAntecipado(boolean pagamentoAntecipado) {
        this.pagamentoAntecipado = pagamentoAntecipado;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public PeriodoLocacao getPeriodo() {
        return periodo;
    }

    public void setPeriodo(PeriodoLocacao periodo) {
        this.periodo = periodo;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
}
