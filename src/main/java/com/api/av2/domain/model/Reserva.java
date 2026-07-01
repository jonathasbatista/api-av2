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

    public void setCanalOrigem(String canalOrigem) {
        this.canalOrigem = canalOrigem;
    }

    public void setPeriodo(PeriodoLocacao periodo) {
        this.periodo = periodo;
    }

    public void setDataRetirada(LocalDate dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public void setLojaRetirada(Loja lojaRetirada) {
        this.lojaRetirada = lojaRetirada;
    }
}
