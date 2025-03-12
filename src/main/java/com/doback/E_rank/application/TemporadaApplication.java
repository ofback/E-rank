package com.doback.E_rank.application;

import com.doback.E_rank.entity.Temporada;
import com.doback.E_rank.facade.TemporadaFacade;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TemporadaApplication {

    private final TemporadaFacade temporadaFacade;

    public TemporadaApplication(TemporadaFacade temporadaFacade) {
        this.temporadaFacade = temporadaFacade;
    }

    public List<Temporada> obterTodasTemporadas() {
        return temporadaFacade.listarTemporadas();
    }

    public Optional<Temporada> obterTemporadaPorId(Long id) {
        return temporadaFacade.buscarTemporadaPorId(id);
    }

    public Temporada criarTemporada(Temporada temporada) {
        return temporadaFacade.salvarTemporada(temporada);
    }

    public void excluirTemporada(Long id) {
        temporadaFacade.excluirTemporada(id);
    }
}
