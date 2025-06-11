package com.doback.E_rank.facade;
import com.doback.E_rank.application.VotacaoEstatisticasApplication;
import com.doback.E_rank.infrastructure.models.VotacaoEstatisticasModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VotacaoEstatisticasFacade {
    private final VotacaoEstatisticasApplication votacaoEstatisticasApplication;

    public VotacaoEstatisticasFacade(VotacaoEstatisticasApplication votacaoEstatisticasApplication) {
        this.votacaoEstatisticasApplication = votacaoEstatisticasApplication;
    }

    public List<VotacaoEstatisticasModel> listarVotacaoEstatisticas() {
        return votacaoEstatisticasApplication.obterTodosVotacaoEstatisticas();
    }

    public VotacaoEstatisticasModel buscarVotacaoEstatisticasPorId(int id) {
        return votacaoEstatisticasApplication.obterVotacaoEstatisticasPorId(id);
    }

    public void salvarVotacaoEstatisticas(VotacaoEstatisticasModel votacaoEstatisticasModel) {
        votacaoEstatisticasApplication.criarVotacaoEstatisticas(votacaoEstatisticasModel);
    }

    public void excluirVotacaoEstatisticas(int id) {
        votacaoEstatisticasApplication.excluirVotacaoEstatisticas(id);
    }

    public void atualizarVotacaoEstatisticas(int id, VotacaoEstatisticasModel votacaoEstatisticasModel) {
        votacaoEstatisticasApplication.atualizarVotacaoEstatisticas(id, votacaoEstatisticasModel);
    }
}
