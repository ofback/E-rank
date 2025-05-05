package com.doback.E_rank.application;
import com.doback.E_rank.entity.VotacaoEstatisticas;
import com.doback.E_rank.models.VotacaoEstatisticasModel;
import com.doback.E_rank.interfaces.VotacaoEstatisticasRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        int usuarioId = votacaoEstatisticasModel.getIdUsuario();
        int estatisticaId = votacaoEstatisticasModel.getIdEstatistica();

        List<VotacaoEstatisticasModel> todosVotos = votacaoEstatisticasRepository.buscar();

        boolean jaVotou = todosVotos.stream().anyMatch(v ->
                v.getIdUsuario() == usuarioId && v.getIdEstatistica() == estatisticaId
        );

        VotacaoEstatisticas.validarVotoDuplicado(jaVotou);

        Date dataLimite = java.sql.Date.valueOf("2025-04-30");
        VotacaoEstatisticas.validarSePodeVotar(dataLimite);

        votacaoEstatisticasModel.setData_voto(new Date());


        votacaoEstatisticasRepository.addVotacaoEstatisticas(votacaoEstatisticasModel);
    }

    public void excluirVotacaoEstatisticas(int id) {
        votacaoEstatisticasRepository.removeVotacaoEstatisticas(id);
    }

    public void atualizarVotacaoEstatisticas(int id, VotacaoEstatisticasModel votacaoEstatisticasModel) {
        votacaoEstatisticasRepository.updateVotacaoEstatisticas(id, votacaoEstatisticasModel);
    }
}
