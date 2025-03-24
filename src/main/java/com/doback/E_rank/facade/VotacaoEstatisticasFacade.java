package com.doback.E_rank.facade;
import com.doback.E_rank.application.VotacaoEstatisticasApplication;
import com.doback.E_rank.entity.VotacaoEstatisticas;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VotacaoEstatisticasFacade {
    private final VotacaoEstatisticasApplication votacaoEstatisticasApplication;

    public VotacaoEstatisticasFacade(VotacaoEstatisticasApplication votacaoEstatisticasApplication) {
        this.votacaoEstatisticasApplication = votacaoEstatisticasApplication;
    }

    public List<VotacaoEstatisticas> listarVotacaoEstatisticas() {
        return votacaoEstatisticasApplication.obterTodosVotacaoEstatisticas();
    }

    public VotacaoEstatisticas buscarVotacaoEstatisticasPorId(int id) {
        return votacaoEstatisticasApplication.obterVotacaoEstatisticasPorId(id);
    }

    public void salvarVotacaoEstatisticas(VotacaoEstatisticas votacaoEstatisticas) {
        votacaoEstatisticasApplication.criarVotacaoEstatisticas(votacaoEstatisticas);
    }

    public void excluirVotacaoEstatisticas(int id) {
        votacaoEstatisticasApplication.excluirVotacaoEstatisticas(id);
    }

    public void atualizarVotacaoEstatisticas(int id, VotacaoEstatisticas votacaoEstatisticas) {
        votacaoEstatisticasApplication.atualizarVotacaoEstatisticas(id, votacaoEstatisticas);
    }
}
