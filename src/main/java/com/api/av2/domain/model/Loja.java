package com.api.av2.domain.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "lojas")
@Data
public class Loja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cidade;
    private boolean emAeroporto;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEmAeroporto(boolean emAeroporto) {
        this.emAeroporto = emAeroporto;
    }
}
