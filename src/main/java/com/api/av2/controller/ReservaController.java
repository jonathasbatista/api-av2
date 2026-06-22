package com.api.av2.controller;

import com.api.av2.application.dto.ReservaRequestDTO;
import com.api.av2.application.service.ReservaService;
import com.api.av2.domain.model.Reserva;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    public ResponseEntity<Reserva> criarReserva(@RequestBody ReservaRequestDTO dto) {
        Reserva reserva = reservaService.criarReserva(dto);
        return new ResponseEntity<>(reserva, HttpStatus.CREATED);
    }
}
