package com.api.av2.controller;

import com.api.av2.application.dto.RelatorioDTO;
import com.api.av2.application.service.RelatorioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/relatorios")
public class RelatorioController {

    private final RelatorioService relatorioService;

    public RelatorioController(RelatorioService relatorioService) {
        this.relatorioService = relatorioService;
    }

    @GetMapping
    public ResponseEntity<RelatorioDTO> obterEstatisticas() {
        RelatorioDTO relatorio = relatorioService.gerarEstatisticas();
        return new ResponseEntity<>(relatorio, HttpStatus.OK);
    }
}