package com.api.av2.application.service;

import com.api.av2.application.dto.ReservaRequestDTO;
import com.api.av2.domain.model.Loja;
import com.api.av2.domain.model.PeriodoLocacao;
import com.api.av2.domain.model.Reserva;
import com.api.av2.domain.repository.LojaRepository;
import com.api.av2.domain.repository.ReservaRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final LojaRepository lojaRepository;

    public ReservaService(ReservaRepository reservaRepository, LojaRepository lojaRepository) {
        this.reservaRepository = reservaRepository;
        this.lojaRepository = lojaRepository;
    }

    public Reserva criarReserva(ReservaRequestDTO dto) {
        Loja loja = lojaRepository.findById(dto.getLojaRetiradaId()).orElseThrow();

        Reserva reserva = new Reserva();
        reserva.setCanalOrigem(dto.getCanalOrigem());
        reserva.setDataRetirada(dto.getDataRetirada());
        reserva.setPeriodo(PeriodoLocacao.valueOf(dto.getPeriodo()));
        reserva.setLojaRetirada(loja);

        return reservaRepository.save(reserva);
    }
}
