package com.api.av2.application.service;

import com.api.av2.application.dto.LocacaoRequestDTO;
import com.api.av2.domain.model.*;
import com.api.av2.domain.repository.CarroRepository;
import com.api.av2.domain.repository.ClienteRepository;
import com.api.av2.domain.repository.LocacaoRepository;
import com.api.av2.domain.repository.LojaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class LocacaoService {

    private final LocacaoRepository locacaoRepository;
    private final CarroRepository carroRepository;
    private final ClienteRepository clienteRepository;
    private final LojaRepository lojaRepository;

    public LocacaoService(LocacaoRepository locacaoRepository, CarroRepository carroRepository, ClienteRepository clienteRepository, LojaRepository lojaRepository) {
        this.locacaoRepository = locacaoRepository;
        this.carroRepository = carroRepository;
        this.clienteRepository = clienteRepository;
        this.lojaRepository = lojaRepository;
    }

    public Locacao realizarLocacao(LocacaoRequestDTO dto) {
        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Loja loja = lojaRepository.findById(dto.getLojaRetiradaId())
                .orElseThrow(() -> new RuntimeException("Loja não encontrada"));
        String cidade = loja.getCidade();

        List<Carro> carrosLivres = carroRepository.findByStatusAndLojaAtualCidade(StatusCarro.LIVRE, cidade);

        if (carrosLivres.isEmpty()) {
            throw new RuntimeException("Nenhum carro disponível na cidade");
        }

        Carro carroAlocado = carrosLivres.get(0);
        carroAlocado.setStatus(StatusCarro.ALUGADO);
        carroRepository.save(carroAlocado);

        int dias = 0;
        if (dto.getPeriodo() == PeriodoLocacao.SETE_DIAS) {
            dias = 7;
        } else if (dto.getPeriodo() == PeriodoLocacao.QUINZE_DIAS) {
            dias = 15;
        } else if (dto.getPeriodo() == PeriodoLocacao.TRINTA_DIAS) {
            dias = 30;
        }

        double valorCalculado = carroAlocado.getValorDiaria() * dias;

        Locacao locacao = new Locacao();
        locacao.setCliente(cliente);
        locacao.setCarro(carroAlocado);
        locacao.setDataInicio(dto.getDataInicio());
        locacao.setPeriodo(dto.getPeriodo());
        locacao.setPagamentoAntecipado(dto.getPagamentoAntecipado());
        locacao.setComMotorista(dto.getComMotorista());
        locacao.setValorTotal(valorCalculado);

        return locacaoRepository.save(locacao);
    }
}
