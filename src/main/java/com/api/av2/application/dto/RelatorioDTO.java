package com.api.av2.application.dto;

import lombok.Data;

@Data
public class RelatorioDTO {
    private long totalLocacoesRealizadas;
    private long totalCarrosLivres;
    private long totalCarrosAlugados;
    private long totalCarrosEmManutencao;

    public long getTotalLocacoesRealizadas() {
        return totalLocacoesRealizadas;
    }

    public void setTotalLocacoesRealizadas(long totalLocacoesRealizadas) {
        this.totalLocacoesRealizadas = totalLocacoesRealizadas;
    }

    public long getTotalCarrosLivres() {
        return totalCarrosLivres;
    }

    public void setTotalCarrosLivres(long totalCarrosLivres) {
        this.totalCarrosLivres = totalCarrosLivres;
    }

    public long getTotalCarrosAlugados() {
        return totalCarrosAlugados;
    }

    public void setTotalCarrosAlugados(long totalCarrosAlugados) {
        this.totalCarrosAlugados = totalCarrosAlugados;
    }

    public long getTotalCarrosEmManutencao() {
        return totalCarrosEmManutencao;
    }

    public void setTotalCarrosEmManutencao(long totalCarrosEmManutencao) {
        this.totalCarrosEmManutencao = totalCarrosEmManutencao;
    }
}
