package com.doback.E_rank.application;
import com.doback.E_rank.models.VotacaoEstatisticas;
import com.doback.E_rank.interfaces.VotacaoEstatisticasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class VotacaoEstatisticasApplication {
    private final VotacaoEstatisticasRepository votacaoEstatisticasRepository;

    public VotacaoEstatisticasApplication(VotacaoEstatisticasRepository votacaoEstatisticasRepository) {
        this.votacaoEstatisticasRepository = votacaoEstatisticasRepository;
    }

    public List<VotacaoEstatisticas> obterTodosVotacaoEstatisticas() {
        return votacaoEstatisticasRepository.buscar();
    }

    public VotacaoEstatisticas obterVotacaoEstatisticasPorId(int id) {
        return votacaoEstatisticasRepository.searchByCode(id);
    }

    public void criarVotacaoEstatisticas(VotacaoEstatisticas votacaoEstatisticas) {
        votacaoEstatisticasRepository.addVotacaoEstatisticas(votacaoEstatisticas);
    }

    public void excluirVotacaoEstatisticas(int id) {
        votacaoEstatisticasRepository.removeVotacaoEstatisticas(id);
    }

    public void atualizarVotacaoEstatisticas(int id, VotacaoEstatisticas votacaoEstatisticas) {
        votacaoEstatisticasRepository.updateVotacaoEstatisticas(id, votacaoEstatisticas);
    }
}
