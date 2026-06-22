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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public StatusCarro getStatus() {
        return status;
    }

    public void setStatus(StatusCarro status) {
        this.status = status;
    }

    public Loja getLojaAtual() {
        return lojaAtual;
    }

    public void setLojaAtual(Loja lojaAtual) {
        this.lojaAtual = lojaAtual;
    }
}