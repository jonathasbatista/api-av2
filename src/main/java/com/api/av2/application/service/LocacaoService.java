package com.api.av2.application.service;

import com.api.av2.application.dto.LocacaoRequestDTO;
import com.api.av2.domain.model.*;
import com.api.av2.domain.repository.CarroRepository;
import com.api.av2.domain.repository.LocacaoRepository;
import com.api.av2.domain.repository.LojaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class LocacaoService {

    private final LocacaoRepository locacaoRepository;
    private final CarroRepository carroRepository;
    private final LojaRepository lojaRepository;

    public LocacaoService(LocacaoRepository locacaoRepository, CarroRepository carroRepository, LojaRepository lojaRepository) {
        this.locacaoRepository = locacaoRepository;
        this.carroRepository = carroRepository;
        this.lojaRepository = lojaRepository;
    }

    public Locacao efetuarLocacao(LocacaoRequestDTO dto) {
        Loja loja = lojaRepository.findById(dto.getLojaId()).orElseThrow();

        List<Carro> carrosDisponiveis = carroRepository.findByStatusAndLojaAtual_Cidade(StatusCarro.LIVRE, loja.getCidade());

        if (carrosDisponiveis.isEmpty()) {
            throw new RuntimeException("Nenhum carro disponível na cidade.");
        }

        Carro carroAlocado = carrosDisponiveis.get(0);
        carroAlocado.setStatus(StatusCarro.ALUGADO);
        carroRepository.save(carroAlocado);

        Locacao locacao = new Locacao();
        locacao.setCarro(carroAlocado);
        locacao.setDataInicio(dto.getDataInicio());
        locacao.setComMotorista(dto.getComMotorista());
        locacao.setPagamentoAntecipado(true);
        locacao.setPeriodo(PeriodoLocacao.valueOf(dto.getPeriodo()));
        locacao.setValorTotal(new BigDecimal("1000.00"));

        return locacaoRepository.save(locacao);
    }
}
