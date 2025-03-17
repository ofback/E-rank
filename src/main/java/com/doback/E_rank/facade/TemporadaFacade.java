package com.doback.E_rank.facade;

import com.doback.E_rank.application.TemporadaApplication;
import com.doback.E_rank.entity.Temporada;
import com.doback.E_rank.repository.TemporadaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TemporadaFacade {

    private final TemporadaApplication temporadaApplication;

    public TemporadaFacade(TemporadaApplication temporadaApplication) {
        this.temporadaApplication = temporadaApplication;
    }

    public List<Temporada> listarTemporadas() {
        return TemporadaApplication.obterTodasTemporada();
    }

    public Temporada buscarTemporadaPorId(Long id) {
        return temporadaApplication.obterTemporadaPorId(id);
    }

    public void salvarTemporada(Temporada temporada) {
        temporadaApplication.criarTemporada(temporada);
    }

    public void excluirTemporada(Long id) {
        temporadaApplication.excluirTemporada(id);
    }
}
