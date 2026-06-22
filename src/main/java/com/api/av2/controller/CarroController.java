package com.api.av2.controller;

import com.api.av2.application.dto.CarroRequestDTO;
import com.api.av2.application.service.CarroService;
import com.api.av2.domain.model.Carro;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/carros")
public class CarroController {

    private final CarroService carroService;

    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    @PostMapping
    public ResponseEntity<Carro> criarCarro(@RequestBody CarroRequestDTO dto) {
        Carro carro = carroService.criarCarro(dto);
        return new ResponseEntity<>(carro, HttpStatus.CREATED);
    }
}