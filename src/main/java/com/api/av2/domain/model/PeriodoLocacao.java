package com.api.av2.domain.model;

public enum PeriodoLocacao {
    SETE_DIAS(7),
    QUINZE_DIAS(15),
    TRINTA_DIAS(30);

    private final int dias;

    PeriodoLocacao(int dias) {
        this.dias = dias;
    }

    public int getDias() {
        return dias;
    }
}
