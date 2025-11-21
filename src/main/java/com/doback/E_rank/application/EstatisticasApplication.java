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
        // 1. Validar Desafio
        DesafiosModel desafio = desafiosJpa.findById(dto.getDesafioId())
                .orElseThrow(() -> new ResourceNotFoundException("Desafio não encontrado."));

        if (!"A".equals(desafio.getStatus())) {
            throw new IllegalStateException("O desafio não está ativo (Status deve ser 'A').");
        }

        if (desafio.getDesafianteId() != usuarioId && desafio.getDesafiadoId() != usuarioId) {
            throw new IllegalArgumentException("Você não faz parte deste desafio.");
        }

        UsuariosModel usuario = usuariosJpa.findById(usuarioId).orElseThrow();

        // 2. Salvar Estatísticas
        EstatisticasModel stats = new EstatisticasModel();
        stats.setUsuariosModel(usuario);
        stats.setJogosModel(desafio.getJogosModel());
        stats.setDesafiosModel(desafio);

        // Preenche dados do DTO
        stats.setPontos(dto.getPontos());
        stats.setResultadoVitoria(dto.isVitoria());
        stats.setKills(dto.getKills());
        stats.setAssistencias(dto.getAssistencias());
        stats.setHeadshots(dto.getHeadshots());

        // --- CORREÇÃO AQUI: 'estatisticasJpa' (variável) e não 'EstatisticasJpa' (classe) ---
        estatisticasJpa.save(stats);

        // 3. Atualizar Desafio para 'C' (Concluído/Aguardando Validação)
        desafio.setStatus("C");
        desafio.setResultado(dto.isVitoria() ? "Vitória declarada por " + usuario.getNickname() : "Derrota declarada por " + usuario.getNickname());
        desafiosJpa.save(desafio);
    }
}