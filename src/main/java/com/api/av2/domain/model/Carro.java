package com.api.av2.domain.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "carros")
@Data
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placa;
    private String modelo;
    private String marca;

    @Enumerated(EnumType.STRING)
    private StatusCarro status;

    @ManyToOne
    @JoinColumn(name = "loja_id")
    private Loja lojaAtual;

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setStatus(StatusCarro status) {
        this.status = status;
    }

    public void setLojaAtual(Loja lojaAtual) {
        this.lojaAtual = lojaAtual;
    }
}