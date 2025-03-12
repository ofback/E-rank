package com.doback.E_rank.facade;

import com.doback.E_rank.entity.VotacaoEstatistica;
import com.doback.E_rank.repository.VotacaoEstatisticaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class VotacaoEstatisticaFacade {

    private final VotacaoEstatisticaRepository votacaoEstatisticaRepository;

    public VotacaoEstatisticaFacade(VotacaoEstatisticaRepository votacaoEstatisticaRepository) {
        this.votacaoEstatisticaRepository = votacaoEstatisticaRepository;
    }

    public List<VotacaoEstatistica> listarVotacoes() {
        return votacaoEstatisticaRepository.findAll();
    }

    public Optional<VotacaoEstatistica> buscarVotacaoPorId(Long id) {
        return votacaoEstatisticaRepository.findById(id);
    }

    public VotacaoEstatistica salvarVotacao(VotacaoEstatistica votacaoEstatistica) {
        return votacaoEstatisticaRepository.save(votacaoEstatistica);
    }

    public void excluirVotacao(Long id) {
        votacaoEstatisticaRepository.deleteById(id);
    }
}
