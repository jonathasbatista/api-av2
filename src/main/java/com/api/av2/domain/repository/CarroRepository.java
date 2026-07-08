package com.api.av2.domain.repository;

import com.api.av2.domain.model.Carro;
import com.api.av2.domain.model.StatusCarro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
    List<Carro> findByStatusAndLojaAtualCidade(StatusCarro status, String cidade);
    long countByStatus(StatusCarro status);
}