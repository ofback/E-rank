package com.doback.E_rank.application;

import com.doback.E_rank.dto.CreateDesafioDTO;
import com.doback.E_rank.dto.DesafioResponseDTO;
import com.doback.E_rank.exceptions.ResourceNotFoundException;
import com.doback.E_rank.infrastructure.models.AmizadesModel;
import com.doback.E_rank.infrastructure.models.DesafiosModel;
import com.doback.E_rank.infrastructure.models.JogosModel;
import com.doback.E_rank.infrastructure.repository.jpa.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DesafiosApplication {

    private final DesafiosJpa desafiosJpa;
    private final UsuariosJpa usuariosJpa;
    private final JogosJpa jogosJpa;
    private final AmizadesJpa amizadesJpa;
    private final EstatisticasJpa estatisticasJpa;

    public DesafiosApplication(DesafiosJpa desafiosJpa, UsuariosJpa usuariosJpa, JogosJpa jogosJpa, AmizadesJpa amizadesJpa, EstatisticasJpa estatisticasJpa) {
        this.desafiosJpa = desafiosJpa;
        this.usuariosJpa = usuariosJpa;
        this.jogosJpa = jogosJpa;
        this.amizadesJpa = amizadesJpa;
        this.estatisticasJpa = estatisticasJpa;
    }

    @Transactional
    public void criarDesafio(CreateDesafioDTO dto, int desafianteId) {
        if (dto.getDesafiadoId() == desafianteId) {
            throw new IllegalArgumentException("Você não pode desafiar a si mesmo.");
        }

        JogosModel jogo = jogosJpa.findById(dto.getJogoId())
                .orElseThrow(() -> new ResourceNotFoundException("Jogo não encontrado."));

        AmizadesModel amizade = buscarAmizadeEntreUsuarios(desafianteId, dto.getDesafiadoId());

        DesafiosModel model = new DesafiosModel();
        model.setDesafianteId(desafianteId);
        model.setDesafiadoId(dto.getDesafiadoId());
        model.setStatus("P");
        model.setDataHora(LocalDateTime.now());
        model.setJogosModel(jogo);
        model.setAmizadesModel(amizade);

        desafiosJpa.save(model);
    }

    private AmizadesModel buscarAmizadeEntreUsuarios(int u1, int u2) {
        List<AmizadesModel> list1 = amizadesJpa.findByIdUsuario1AndIdUsuario2(u1, u2);
        if (!list1.isEmpty()) return list1.get(0);

        List<AmizadesModel> list2 = amizadesJpa.findByIdUsuario1AndIdUsuario2(u2, u1);
        if (!list2.isEmpty()) return list2.get(0);

        throw new IllegalArgumentException("Vocês precisam ser amigos para criar um desafio.");
    }

    public List<DesafioResponseDTO> listarPendentes(int userId) {
        return desafiosJpa.findByDesafiadoIdAndStatus(userId, "P").stream()
                .map(d -> new DesafioResponseDTO(
                        d.getId(),
                        d.getDesafiante().getNickname(),
                        d.getStatus(),
                        d.getDataHora().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))
                ))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<DesafioResponseDTO> listarAceitos(int userId) {
        return desafiosJpa.findAceitosPorUsuario(userId).stream()
                .map(d -> {
                    boolean jaRegistrei = estatisticasJpa.existsByDesafiosModelIdAndUsuariosModelId(d.getId(), userId);
                    String statusVisual;
                    if (jaRegistrei) {
                        statusVisual = "AGUARDANDO";
                    } else {
                        statusVisual = "REGISTRAR";
                    }

                    return new DesafioResponseDTO(
                            d.getId(),
                            (d.getDesafianteId() == userId)
                                    ? "Oponente (ID " + d.getDesafiadoId() + ")"
                                    : d.getDesafiante().getNickname(),
                            statusVisual,
                            d.getDataHora().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))
                    );
                })
                .collect(Collectors.toList());
    }

    @Transactional
    public void responderDesafio(int desafioId, int userId, boolean aceitar) {
        DesafiosModel desafio = desafiosJpa.findById(desafioId)
                .orElseThrow(() -> new ResourceNotFoundException("Desafio não encontrado."));

        if (desafio.getDesafiadoId() != userId) {
            throw new IllegalArgumentException("Este desafio não é para você.");
        }

        if (!"P".equals(desafio.getStatus())) {
            throw new IllegalStateException("O desafio não está mais pendente.");
        }

        desafio.setStatus(aceitar ? "A" : "R");
        desafiosJpa.save(desafio);
    }
}