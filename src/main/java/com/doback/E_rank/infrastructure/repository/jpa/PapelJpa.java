package com.doback.E_rank.infrastructure.repository.jpa;

import com.doback.E_rank.infrastructure.models.PapelModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PapelJpa extends JpaRepository<PapelModel, Integer> {
    PapelModel findByNome(String nome);
}