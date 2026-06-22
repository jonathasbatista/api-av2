package com.api.av2.application.service;

import com.api.av2.application.dto.RelatorioDTO;
import com.api.av2.domain.model.StatusCarro;
import com.api.av2.domain.repository.CarroRepository;
import com.api.av2.domain.repository.LocacaoRepository;
import org.springframework.stereotype.Service;

@Service
public class RelatorioService {

    private final LocacaoRepository locacaoRepository;
    private final CarroRepository carroRepository;

    public RelatorioService(LocacaoRepository locacaoRepository, CarroRepository carroRepository) {
        this.locacaoRepository = locacaoRepository;
        this.carroRepository = carroRepository;
    }

    public RelatorioDTO gerarEstatisticas() {
        RelatorioDTO relatorio = new RelatorioDTO();
        relatorio.setTotalLocacoesRealizadas(locacaoRepository.count());
        relatorio.setTotalCarrosLivres(carroRepository.countByStatus(StatusCarro.LIVRE));
        relatorio.setTotalCarrosAlugados(carroRepository.countByStatus(StatusCarro.ALUGADO));
        relatorio.setTotalCarrosEmManutencao(carroRepository.countByStatus(StatusCarro.MANUTENCAO));

        return relatorio;
    }
}