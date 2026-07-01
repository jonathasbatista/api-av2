package com.api.av2.application.dto;

import lombok.Data;

@Data
public class RelatorioDTO {
    private long totalLocacoesRealizadas;
    private long totalCarrosLivres;
    private long totalCarrosAlugados;
    private long totalCarrosEmManutencao;

    public void setTotalLocacoesRealizadas(long totalLocacoesRealizadas) {
        this.totalLocacoesRealizadas = totalLocacoesRealizadas;
    }

    public void setTotalCarrosLivres(long totalCarrosLivres) {
        this.totalCarrosLivres = totalCarrosLivres;
    }

    public void setTotalCarrosAlugados(long totalCarrosAlugados) {
        this.totalCarrosAlugados = totalCarrosAlugados;
    }

    public void setTotalCarrosEmManutencao(long totalCarrosEmManutencao) {
        this.totalCarrosEmManutencao = totalCarrosEmManutencao;
    }
}
