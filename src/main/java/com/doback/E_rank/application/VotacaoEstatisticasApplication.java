package com.doback.E_rank.application;
import com.doback.E_rank.models.VotacaoEstatisticasModel;
import com.doback.E_rank.interfaces.VotacaoEstatisticasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class VotacaoEstatisticasApplication {
    private final VotacaoEstatisticasRepository votacaoEstatisticasRepository;

    public VotacaoEstatisticasApplication(VotacaoEstatisticasRepository votacaoEstatisticasRepository) {
        this.votacaoEstatisticasRepository = votacaoEstatisticasRepository;
    }

    public List<VotacaoEstatisticasModel> obterTodosVotacaoEstatisticas() {
        return votacaoEstatisticasRepository.buscar();
    }

    public VotacaoEstatisticasModel obterVotacaoEstatisticasPorId(int id) {
        return votacaoEstatisticasRepository.searchByCode(id);
    }

    public void criarVotacaoEstatisticas(VotacaoEstatisticasModel votacaoEstatisticasModel) {
        votacaoEstatisticasRepository.addVotacaoEstatisticas(votacaoEstatisticasModel);
    }

    public void excluirVotacaoEstatisticas(int id) {
        votacaoEstatisticasRepository.removeVotacaoEstatisticas(id);
    }

    public void atualizarVotacaoEstatisticas(int id, VotacaoEstatisticasModel votacaoEstatisticasModel) {
        votacaoEstatisticasRepository.updateVotacaoEstatisticas(id, votacaoEstatisticasModel);
    }
}
