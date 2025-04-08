package com.doback.E_rank.facade;

import com.doback.E_rank.application.TemporadasApplication;
import com.doback.E_rank.entity.Temporadas;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TemporadasFacade {

    private final TemporadasApplication temporadaApplication;

    public TemporadasFacade(TemporadasApplication temporadaApplication) {
        this.temporadaApplication = temporadaApplication;
    }

    public List<Temporadas> listarTemporadas() {
        return temporadaApplication.obterTodasTemporadas();
    }

    public Temporadas buscarTemporadaPorId(int id) {
        return temporadaApplication.obterTemporadaPorId(id);
    }

    public void salvarTemporada(Temporadas temporada) {
        temporadaApplication.criarTemporada(temporada);
    }

    public void excluirTemporada(long id) {
        temporadaApplication.excluirTemporada(id);
    }
}
