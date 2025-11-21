package com.doback.E_rank.facade;

import com.doback.E_rank.application.EstatisticasApplication;
import com.doback.E_rank.dto.CreateEstatisticaDTO;
import com.doback.E_rank.infrastructure.models.EstatisticasModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EstatisticasFacade {

    private final EstatisticasApplication estatisticasApplication;

    public EstatisticasFacade(EstatisticasApplication estatisticasApplication) {
        this.estatisticasApplication = estatisticasApplication;
    }

    public void registrar(CreateEstatisticaDTO dto, int usuarioId) {
        // --- CORREÇÃO AQUI: 'estatisticasApplication' (variável) e não 'EstatisticasApplication' (classe) ---
        estatisticasApplication.registrarEstatistica(dto, usuarioId);
    }
}