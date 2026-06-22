package com.api.av2.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "reservas")
@Data
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String canalOrigem;
    private LocalDate dataRetirada;

    @Enumerated(EnumType.STRING)
    private PeriodoLocacao periodo;

    @ManyToOne
    @JoinColumn(name = "loja_retirada_id")
    private Loja lojaRetirada;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCanalOrigem() {
        return canalOrigem;
    }

    public void setCanalOrigem(String canalOrigem) {
        this.canalOrigem = canalOrigem;
    }

    public PeriodoLocacao getPeriodo() {
        return periodo;
    }

    public void setPeriodo(PeriodoLocacao periodo) {
        this.periodo = periodo;
    }

    public LocalDate getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(LocalDate dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public Loja getLojaRetirada() {
        return lojaRetirada;
    }

    public void setLojaRetirada(Loja lojaRetirada) {
        this.lojaRetirada = lojaRetirada;
    }
}
