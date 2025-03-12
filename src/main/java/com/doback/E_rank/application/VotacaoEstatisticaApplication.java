package com.doback.E_rank.application;

import com.doback.E_rank.entity.VotacaoEstatistica;
import com.doback.E_rank.facade.VotacaoEstatisticaFacade;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VotacaoEstatisticaApplication {

    private final VotacaoEstatisticaFacade votacaoEstatisticaFacade;

    public VotacaoEstatisticaApplication(VotacaoEstatisticaFacade votacaoEstatisticaFacade) {
        this.votacaoEstatisticaFacade = votacaoEstatisticaFacade;
    }

    public List<VotacaoEstatistica> obterTodasVotacoes() {
        return votacaoEstatisticaFacade.listarVotacoes();
    }

    public Optional<VotacaoEstatistica> obterVotacaoPorId(Long id) {
        return votacaoEstatisticaFacade.buscarVotacaoPorId(id);
    }

    public VotacaoEstatistica criarVotacao(VotacaoEstatistica votacaoEstatistica) {
        return votacaoEstatisticaFacade.salvarVotacao(votacaoEstatistica);
    }

    public void excluirVotacao(Long id) {
        votacaoEstatisticaFacade.excluirVotacao(id);
    }
}
