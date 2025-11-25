package com.doback.E_rank.facade;

import com.doback.E_rank.application.EstatisticasApplication;
import com.doback.E_rank.dto.CreateEstatisticaDTO;
import com.doback.E_rank.dto.EstatisticasConsolidadasDTO;
import org.springframework.stereotype.Component;

@Component
public class EstatisticasFacade {

    private final EstatisticasApplication estatisticasApplication;

    public EstatisticasFacade(EstatisticasApplication estatisticasApplication) {
        this.estatisticasApplication = estatisticasApplication;
    }

    public void registrar(CreateEstatisticaDTO dto, int usuarioId) {
        estatisticasApplication.registrarEstatistica(dto, usuarioId);
    }

    public EstatisticasConsolidadasDTO getConsolidado(int usuarioId) {
        return estatisticasApplication.getConsolidado(usuarioId);
    }
}