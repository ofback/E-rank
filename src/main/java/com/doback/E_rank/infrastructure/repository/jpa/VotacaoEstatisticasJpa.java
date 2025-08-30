package com.doback.E_rank.infrastructure.repository.jpa;

import com.doback.E_rank.infrastructure.models.VotacaoEstatisticasModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotacaoEstatisticasJpa extends JpaRepository<VotacaoEstatisticasModel, Integer>{
    long countByIdEstatistica(int idEstatistica);
}

