package com.doback.E_rank.infrastructure.repository.jpa;

import com.doback.E_rank.infrastructure.models.EstatisticasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EstatisticasJpa extends JpaRepository<EstatisticasModel, Integer> {
    List<EstatisticasModel> findByIdJogoAndStsProvacao(int jogoId, int stsProvacao);
    List<EstatisticasModel> findByIdUsuarioAndStsProvacao(int usuarioId, int stsProvacao);
}
