package com.api.av2.controller;

import com.api.av2.application.dto.LocacaoRequestDTO;
import com.api.av2.application.service.LocacaoService;
import com.api.av2.domain.model.Locacao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/locacoes")
public class LocacaoController {

    private final LocacaoService locacaoService;

    public LocacaoController(LocacaoService locacaoService) {
        this.locacaoService = locacaoService;
    }

    @PostMapping
    public ResponseEntity<Locacao> realizarLocacao(@RequestBody LocacaoRequestDTO dto) {
        Locacao locacao = locacaoService.efetuarLocacao(dto);
        return new ResponseEntity<>(locacao, HttpStatus.CREATED);
    }
}
