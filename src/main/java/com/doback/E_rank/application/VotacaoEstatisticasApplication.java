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

    /**
     * RF10: Validação de Resultado pelo Oponente
     * O usuário logado valida o resultado inserido pelo adversário.
     */
    @Transactional
    public void validarResultado(int desafioId, int usuarioValidadorId, boolean aprovado, String motivoContestacao) {
        // 1. Busca o desafio para garantir que existe
        DesafiosModel desafio = desafiosRepository.findById(desafioId)
                .orElseThrow(() -> new IllegalArgumentException("Desafio não encontrado."));

        // 2. Busca as estatísticas lançadas para esse desafio
        List<EstatisticasModel> statsDoDesafio = estatisticasRepository.findByDesafiosModelId(desafioId);

        if (statsDoDesafio.isEmpty()) {
            throw new IllegalArgumentException("Nenhuma estatística registrada para este desafio ainda.");
        }

        // 3. Lógica de Validação Cruzada
        boolean isParticipante = false;

        // CORREÇÃO: Usando getDesafianteId() e getDesafiadoId() diretamente (campos int)
        // em vez de tentar acessar o objeto completo que pode não estar mapeado.
        if (desafio.getDesafianteId() == usuarioValidadorId ||
                desafio.getDesafiadoId() == usuarioValidadorId) {
            isParticipante = true;
        }

        if (!isParticipante) {
            throw new SecurityException("Apenas participantes do desafio podem validar o resultado.");
        }

        // 4. Processa a Validação
        if (aprovado) {
            for (EstatisticasModel stat : statsDoDesafio) {
                // Se estiver pendente (0), aprova (1).
                if (stat.getStsProvacao() == 0) {
                    stat.setStsProvacao(1); // 1 = Aprovado
                    estatisticasRepository.save(stat);
                }
            }
        } else {
            // Se contestado
            System.out.println("Desafio " + desafioId + " contestado por usuário " + usuarioValidadorId + ". Motivo: " + motivoContestacao);

            for (EstatisticasModel stat : statsDoDesafio) {
                stat.setStsProvacao(2); // 2 = Contestado
                estatisticasRepository.save(stat);
            }
        }
    }
}