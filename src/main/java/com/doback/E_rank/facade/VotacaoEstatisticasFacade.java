package com.doback.E_rank.facade;

import com.doback.E_rank.application.VotacaoEstatisticasApplication;
import org.springframework.stereotype.Component;

@Component
public class VotacaoEstatisticasFacade {

    private final VotacaoEstatisticasApplication votacaoApplication;

    public VotacaoEstatisticasFacade(VotacaoEstatisticasApplication votacaoApplication) {
        this.votacaoApplication = votacaoApplication;
    }

    public void validarResultado(int desafioId, int usuarioId, boolean aprovado, String motivo) {
        votacaoApplication.validarResultado(desafioId, usuarioId, aprovado, motivo);
    }
}