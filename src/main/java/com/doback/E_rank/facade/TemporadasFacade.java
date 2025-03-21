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
        return TemporadasApplication.obterTodasTemporada();
    }

    public Temporadas buscarTemporadaPorId(Long id) {
        return temporadaApplication.obterTemporadaPorId(id);
    }

    public void salvarTemporada(Temporadas temporada) {
        temporadaApplication.criarTemporada(temporada);
    }

    public void excluirTemporada(Long id) {
        temporadaApplication.excluirTemporada(id);
    }
}
