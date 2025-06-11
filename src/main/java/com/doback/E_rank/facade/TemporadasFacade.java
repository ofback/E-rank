package com.doback.E_rank.facade;

import com.doback.E_rank.application.TemporadasApplication;
import com.doback.E_rank.infrastructure.models.TemporadasModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TemporadasFacade {

    private final TemporadasApplication temporadaApplication;

    public TemporadasFacade(TemporadasApplication temporadaApplication) {
        this.temporadaApplication = temporadaApplication;
    }

    public List<TemporadasModel> listarTemporadas() {
        return temporadaApplication.obterTodasTemporadas();
    }

    public TemporadasModel buscarTemporadaPorId(int id) {
        return temporadaApplication.obterTemporadaPorId(id);
    }

    public void salvarTemporada(TemporadasModel temporada) {
        temporadaApplication.criarTemporada(temporada);
    }

    public void excluirTemporada(int id) {
        temporadaApplication.excluirTemporada(id);
    }

    public void atualizarTemporadas(int id, TemporadasModel temporadasModel) {
        temporadaApplication.atualizarTemporadas(id, temporadasModel);
    }
}
