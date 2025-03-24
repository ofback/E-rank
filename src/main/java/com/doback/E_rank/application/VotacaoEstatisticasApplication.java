package com.doback.E_rank.application;
import com.doback.E_rank.entity.VotacaoEstatisticas;
import com.doback.E_rank.repository.VotacaoEstatisticasRepository;
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

    public VotacaoEstatisticas obterVotacaoEstatisticasPorId(long id) {
        return votacaoEstatisticasRepository.buscarPorId(id);
    }

    public void criarVotacaoEstatisticas(VotacaoEstatisticas votacaoEstatisticas) {
        votacaoEstatisticasRepository.adicionar(votacaoEstatisticas);
    }

    public void excluirVotacaoEstatisticas(Long id) {
        votacaoEstatisticasRepository.remover(id);
    }

    public void atualizarVotacaoEstatisticas(Long id, VotacaoEstatisticas votacaoEstatisticas) {
        votacaoEstatisticasRepository.atualizar(id, votacaoEstatisticas);
    }
}
