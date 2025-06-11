package com.doback.E_rank.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import com.doback.E_rank.infrastructure.models.VotacaoEstatisticasModel;

public interface VotacaoEstatisticasJpa extends JpaRepository<VotacaoEstatisticasModel, Integer>{
}
