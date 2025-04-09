package com.doback.E_rank.facade;

import com.doback.E_rank.application.TemporadasApplication;
import com.doback.E_rank.entity.RegistroTimes;
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

    public void atualizarTemporadas(int id, Temporadas temporadas) {
        temporadaApplication.atualizarTemporadas(id, temporadas);
    }
}
