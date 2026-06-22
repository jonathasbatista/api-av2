package com.api.av2.controller;

import com.api.av2.application.dto.LojaRequestDTO;
import com.api.av2.application.service.LojaService;
import com.api.av2.domain.model.Loja;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lojas")
public class LojaController {

    private final LojaService lojaService;

    public LojaController(LojaService lojaService) {
        this.lojaService = lojaService;
    }

    @PostMapping
    public ResponseEntity<Loja> criarLoja(@RequestBody LojaRequestDTO dto) {
        Loja loja = lojaService.criarLoja(dto);
        return new ResponseEntity<>(loja, HttpStatus.CREATED);
    }
}
