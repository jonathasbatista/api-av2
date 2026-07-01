package com.api.av2.application.dto;

import lombok.Data;

@Data
public class LojaRequestDTO {
    private String nome;
    private String cidade;
    private boolean emAeroporto;

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public boolean isEmAeroporto() {
        return emAeroporto;
    }
}
