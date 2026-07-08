package com.api.av2.application.dto;

import lombok.Data;

@Data
public class ClienteRequestDTO {
    private String nome;
    private String cpf;
    private String cnh;

    public String getNome() {return nome;}

    public String getCpf() {return cpf;}

    public String getCnh() {return cnh;}
}
