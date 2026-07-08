package com.api.av2.application.service;

import com.api.av2.application.dto.CarroRequestDTO;
import com.api.av2.domain.model.Carro;
import com.api.av2.domain.model.Loja;
import com.api.av2.domain.repository.CarroRepository;
import com.api.av2.domain.repository.LojaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    private final CarroRepository carroRepository;
    private final LojaRepository lojaRepository;

    public CarroService(CarroRepository carroRepository, LojaRepository lojaRepository) {
        this.carroRepository = carroRepository;
        this.lojaRepository = lojaRepository;
    }

    public Carro salvar(CarroRequestDTO dto) {
        Loja loja = lojaRepository.findById(dto.getLojaId())
                .orElseThrow(() -> new RuntimeException("Loja não encontrada"));

        Carro carro = new Carro();
        carro.setPlaca(dto.getPlaca());
        carro.setModelo(dto.getModelo());
        carro.setMarca(dto.getMarca());
        carro.setTipo(dto.getTipo());
        carro.setValorDiaria(dto.getValorDiaria());
        carro.setStatus(dto.getStatus());
        carro.setLojaAtual(loja);

        return carroRepository.save(carro);
    }

    public List<Carro> listarTodos() {
        return carroRepository.findAll();
    }

    public Carro buscarPorId(Long id) {
        return carroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carro não encontrado"));
    }

    public Carro atualizar(Long id, CarroRequestDTO dto) {
        Carro carro = buscarPorId(id);
        Loja loja = lojaRepository.findById(dto.getLojaId())
                .orElseThrow(() -> new RuntimeException("Loja não encontrada"));

        carro.setPlaca(dto.getPlaca());
        carro.setModelo(dto.getModelo());
        carro.setMarca(dto.getMarca());
        carro.setTipo(dto.getTipo());
        carro.setValorDiaria(dto.getValorDiaria());
        carro.setStatus(dto.getStatus());
        carro.setLojaAtual(loja);

        return carroRepository.save(carro);
    }

    public void deletar(Long id) {
        Carro carro = buscarPorId(id);
        carroRepository.delete(carro);
    }
}
