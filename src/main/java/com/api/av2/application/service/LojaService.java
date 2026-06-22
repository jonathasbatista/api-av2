package com.api.av2.application.service;

import com.api.av2.application.dto.LojaRequestDTO;
import com.api.av2.domain.model.Loja;
import com.api.av2.domain.repository.LojaRepository;
import org.springframework.stereotype.Service;

@Service
public class LojaService {

    private final LojaRepository lojaRepository;

    public LojaService(LojaRepository lojaRepository) {
        this.lojaRepository = lojaRepository;
    }

    public Loja criarLoja(LojaRequestDTO dto) {
        Loja loja = new Loja();
        loja.setNome(dto.getNome());
        loja.setCidade(dto.getCidade());
        loja.setEmAeroporto(dto.isEmAeroporto());
        return lojaRepository.save(loja);
    }
}
