package com.doback.E_rank.application;

import com.doback.E_rank.infrastructure.models.DesafiosModel;
import com.doback.E_rank.infrastructure.models.EstatisticasModel;
import com.doback.E_rank.infrastructure.repository.jpa.DesafiosJpa;
import com.doback.E_rank.infrastructure.repository.jpa.EstatisticasJpa;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VotacaoEstatisticasApplication {

    private final EstatisticasJpa estatisticasRepository;
    private final DesafiosJpa desafiosRepository;

    public VotacaoEstatisticasApplication(EstatisticasJpa estatisticasRepository, DesafiosJpa desafiosRepository) {
        this.estatisticasRepository = estatisticasRepository;
        this.desafiosRepository = desafiosRepository;
    }

    @Transactional
    public void validarResultado(int desafioId, int usuarioValidadorId, boolean aprovado, String motivoContestacao) {
        DesafiosModel desafio = desafiosRepository.findById(desafioId)
                .orElseThrow(() -> new IllegalArgumentException("Desafio não encontrado."));

        List<EstatisticasModel> statsDoDesafio = estatisticasRepository.findByDesafiosModelId(desafioId);

        if (statsDoDesafio.isEmpty()) {
            throw new IllegalArgumentException("Nenhuma estatística registrada para este desafio ainda.");
        }

        boolean isParticipante = false;

        if (desafio.getDesafianteId() == usuarioValidadorId ||
                desafio.getDesafiadoId() == usuarioValidadorId) {
            isParticipante = true;
        }

        if (!isParticipante) {
            throw new SecurityException("Apenas participantes do desafio podem validar o resultado.");
        }

        if (aprovado) {
            for (EstatisticasModel stat : statsDoDesafio) {
                if (stat.getStsProvacao() == 0) {
                    stat.setStsProvacao(1);
                    estatisticasRepository.save(stat);
                }
            }
        } else {
            System.out.println("Desafio " + desafioId + " contestado por usuário " + usuarioValidadorId + ". Motivo: " + motivoContestacao);

            for (EstatisticasModel stat : statsDoDesafio) {
                stat.setStsProvacao(2);
                estatisticasRepository.save(stat);
            }
        }
    }
}