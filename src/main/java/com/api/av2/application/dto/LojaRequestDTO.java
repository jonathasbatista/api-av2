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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public boolean isEmAeroporto() {
        return emAeroporto;
    }

    public void setEmAeroporto(boolean emAeroporto) {
        this.emAeroporto = emAeroporto;
    }
}
