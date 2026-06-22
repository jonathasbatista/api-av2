package com.api.av2.application.service;

import com.api.av2.application.dto.CarroRequestDTO;
import com.api.av2.domain.model.Carro;
import com.api.av2.domain.model.Loja;
import com.api.av2.domain.model.StatusCarro;
import com.api.av2.domain.repository.CarroRepository;
import com.api.av2.domain.repository.LojaRepository;
import org.springframework.stereotype.Service;

@Service
public class CarroService {

    private final CarroRepository carroRepository;
    private final LojaRepository lojaRepository;

    public CarroService(CarroRepository carroRepository, LojaRepository lojaRepository) {
        this.carroRepository = carroRepository;
        this.lojaRepository = lojaRepository;
    }

    public Carro criarCarro(CarroRequestDTO dto) {
        Loja loja = lojaRepository.findById(dto.getLojaId()).orElseThrow();

        Carro carro = new Carro();
        carro.setPlaca(dto.getPlaca());
        carro.setModelo(dto.getModelo());
        carro.setMarca(dto.getMarca());
        carro.setStatus(StatusCarro.valueOf(dto.getStatus()));
        carro.setLojaAtual(loja);

        return carroRepository.save(carro);
    }
}
