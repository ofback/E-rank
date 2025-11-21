package com.doback.E_rank.application;

import com.doback.E_rank.dto.CreateEstatisticaDTO;
import com.doback.E_rank.exceptions.ResourceNotFoundException;
import com.doback.E_rank.infrastructure.models.DesafiosModel;
import com.doback.E_rank.infrastructure.models.EstatisticasModel;
import com.doback.E_rank.infrastructure.models.UsuariosModel;
import com.doback.E_rank.infrastructure.repository.jpa.DesafiosJpa;
import com.doback.E_rank.infrastructure.repository.jpa.EstatisticasJpa;
import com.doback.E_rank.infrastructure.repository.jpa.UsuariosJpa;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EstatisticasApplication {

    private final EstatisticasJpa estatisticasJpa;
    private final DesafiosJpa desafiosJpa;
    private final UsuariosJpa usuariosJpa;

    public EstatisticasApplication(EstatisticasJpa estatisticasJpa, DesafiosJpa desafiosJpa, UsuariosJpa usuariosJpa) {
        this.estatisticasJpa = estatisticasJpa;
        this.desafiosJpa = desafiosJpa;
        this.usuariosJpa = usuariosJpa;
    }

    @Transactional
    public void registrarEstatistica(CreateEstatisticaDTO dto, int usuarioId) {
        // 1. Busca o desafio
        DesafiosModel desafio = desafiosJpa.findById(dto.getDesafioId())
                .orElseThrow(() -> new ResourceNotFoundException("Desafio não encontrado."));

        // 2. Validação de Status (Aceita 'A' ou 'W')
        if (!"A".equals(desafio.getStatus()) && !"W".equals(desafio.getStatus())) {
            throw new IllegalStateException("O desafio não está ativo para registro.");
        }

        // 3. Verifica se este usuário JÁ registrou
        if (estatisticasJpa.existsByDesafiosModelIdAndUsuariosModelId(desafio.getId(), usuarioId)) {
            throw new IllegalArgumentException("Você já registrou o resultado para esta partida.");
        }

        // 4. Salva a estatística do usuário
        UsuariosModel usuario = usuariosJpa.findById(usuarioId).orElseThrow();
        EstatisticasModel stats = new EstatisticasModel();
        stats.setUsuariosModel(usuario);
        stats.setJogosModel(desafio.getJogosModel());
        stats.setDesafiosModel(desafio);

        stats.setPontos(dto.getPontos());
        stats.setResultadoVitoria(dto.isVitoria());
        stats.setKills(dto.getKills());
        stats.setAssistencias(dto.getAssistencias());
        stats.setHeadshots(dto.getHeadshots());

        estatisticasJpa.save(stats);

        // 5. Lógica de Status do Desafio
        long registrosExistentes = estatisticasJpa.countByDesafiosModelId(desafio.getId());

        if (registrosExistentes >= 2) {
            // Ambos registraram -> Finaliza ('C')
            desafio.setStatus("C");
            desafio.setResultado("Concluído por ambos");
        } else {
            // Apenas um registrou -> Aguarda o outro ('W')
            desafio.setStatus("W");
            desafio.setResultado("Aguardando confirmação do oponente");
        }

        desafiosJpa.save(desafio);
    }
}