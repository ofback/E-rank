package com.doback.E_rank.application;

import com.doback.E_rank.dto.CreateEstatisticaDTO;
import com.doback.E_rank.dto.EstatisticasConsolidadasDTO;
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

    @Transactional(readOnly = true)
    public EstatisticasConsolidadasDTO getConsolidado(int usuarioId) {
        EstatisticasConsolidadasDTO stats = estatisticasJpa.buscarConsolidadoPorUsuario(usuarioId);

        if (stats == null || stats.getTotalPartidas() == 0) {
            UsuariosModel usuario = usuariosJpa.findById(usuarioId)
                    .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado."));
            return new EstatisticasConsolidadasDTO(usuario.getNickname(), 0, 0, 0, 0, 0, 0);
        }

        return stats;
    }

    @Transactional
    public void registrarEstatistica(CreateEstatisticaDTO dto, int usuarioId) {
        DesafiosModel desafio = desafiosJpa.findById(dto.getDesafioId())
                .orElseThrow(() -> new ResourceNotFoundException("Desafio não encontrado."));

        if (desafio.getDesafianteId() != usuarioId && desafio.getDesafiadoId() != usuarioId) {
            throw new IllegalStateException("Usuário não faz parte deste desafio.");
        }

        if (!"A".equals(desafio.getStatus()) && !"W".equals(desafio.getStatus())) {
            throw new IllegalStateException("O desafio não está ativo para registro (Status: " + desafio.getStatus() + ").");
        }

        if (estatisticasJpa.existsByDesafiosModelIdAndUsuariosModelId(desafio.getId(), usuarioId)) {
            throw new IllegalArgumentException("Você já registrou o resultado para esta partida.");
        }

        UsuariosModel usuario = usuariosJpa.findById(usuarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado."));

        EstatisticasModel stats = new EstatisticasModel();
        stats.setUsuariosModel(usuario);
        stats.setJogosModel(desafio.getJogosModel());
        stats.setDesafiosModel(desafio);

        stats.setPontos(dto.getPontos());
        stats.setResultadoVitoria(dto.isVitoria());
        stats.setKills(dto.getKills());
        stats.setAssistencias(dto.getAssistencias());
        stats.setHeadshots(dto.getHeadshots());
        stats.setStsProvacao(1);

        estatisticasJpa.save(stats);

        long registrosExistentes = estatisticasJpa.countByDesafiosModelId(desafio.getId());

        if (registrosExistentes >= 2) {
            desafio.setStatus("C");
            desafio.setResultado("Concluído por ambos");
        } else {
            desafio.setStatus("W");
            desafio.setResultado("Aguardando confirmação do oponente");
        }

        desafiosJpa.save(desafio);
    }
}