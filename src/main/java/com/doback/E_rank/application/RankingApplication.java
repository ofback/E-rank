package com.doback.E_rank.application;

import com.doback.E_rank.dto.ComparacaoDTO;
import com.doback.E_rank.dto.PlayerCardDTO;
import com.doback.E_rank.dto.RankingDTO;
import com.doback.E_rank.infrastructure.models.EstatisticasModel;
import com.doback.E_rank.infrastructure.models.UsuariosModel;
import com.doback.E_rank.infrastructure.repository.jpa.EstatisticasJpa; // Usando a interface JPA direta para Page
import com.doback.E_rank.interfaces.UsuariosRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RankingApplication {

    private final EstatisticasJpa estatisticasRepository;
    private final UsuariosRepository usuariosRepository;

    public RankingApplication(EstatisticasJpa estatisticasRepository, UsuariosRepository usuariosRepository) {
        this.estatisticasRepository = estatisticasRepository;
        this.usuariosRepository = usuariosRepository;
    }

    /**
     * RF16: Ranking Global Paginado
     */
    public Page<RankingDTO> getRankingGlobal(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<RankingDTO> pagina = estatisticasRepository.buscarRankingGlobal(pageable);

        // Calcula a posição correta baseada na página (Ex: Pagina 1, size 20 -> começa em 21)
        int startRank = (int) pageable.getOffset() + 1;
        int index = 0;
        for (RankingDTO dto : pagina.getContent()) {
            dto.setPosicao(startRank + index);
            index++;
        }
        return pagina;
    }

    public List<RankingDTO> getRankingPorJogo(int jogoId) {
        // Nota: O método findByJogosModelIdAndStsProvacao existe na Interface JPA injetada
        List<EstatisticasModel> estatisticasAprovadas = estatisticasRepository.findByJogosModelIdAndStsProvacao(jogoId, 1);

        List<RankingDTO> ranking = new ArrayList<>();

        for (EstatisticasModel est : estatisticasAprovadas) {
            UsuariosModel usuario = usuariosRepository.searchByCode(est.getUsuariosModel().getId());

            if (usuario != null) {
                // Casting para long conforme novo DTO
                long pontuacao = (est.getVitorias() * 10L) + (est.getKills() * 2L) - (est.getDerrotas() * 5L);
                ranking.add(new RankingDTO(0, usuario.getNickname(), pontuacao, (long)est.getVitorias(), (long)est.getKills()));
            }
        }

        ranking.sort(Comparator.comparingLong(RankingDTO::getPontuacao).reversed());

        for (int i = 0; i < ranking.size(); i++) {
            ranking.get(i).setPosicao(i + 1);
        }

        return ranking;
    }

    public List<ComparacaoDTO> compararJogadores(List<Integer> userIds) {
        return userIds.stream()
                .map(this::getDadosAgregadosDoUsuario)
                .collect(Collectors.toList());
    }

    public PlayerCardDTO getPlayerCard(int userId) {
        UsuariosModel usuario = usuariosRepository.searchByCode(userId);

        if (usuario == null) {
            throw new IllegalArgumentException("Usuário com ID " + userId + " não encontrado.");
        }

        // Ajuste: usando JPA direto ou precisaria expor no repositorio de dominio
        List<EstatisticasModel> estatisticas = estatisticasRepository.findByUsuariosModelIdAndStsProvacao(userId, 1);
        PlayerCardDTO card = new PlayerCardDTO(usuario.getNickname(), usuario.getNome());

        long totalPartidas = estatisticas.stream().mapToLong(EstatisticasModel::getQtdPartidas).sum();
        long totalVitorias = estatisticas.stream().mapToLong(EstatisticasModel::getVitorias).sum();
        long totalDerrotas = estatisticas.stream().mapToLong(EstatisticasModel::getDerrotas).sum();
        long totalKills = estatisticas.stream().mapToLong(EstatisticasModel::getKills).sum();
        long totalAssistencias = estatisticas.stream().mapToLong(EstatisticasModel::getAssistencias).sum();
        long totalHeadshots = estatisticas.stream().mapToLong(EstatisticasModel::getHeadshots).sum();
        long totalDeaths = totalDerrotas == 0 ? 1 : totalDerrotas;

        double kdRatio = (double) totalKills / totalDeaths;
        double vitoriaRatio = totalPartidas > 0 ? ((double) totalVitorias / totalPartidas) * 100 : 0;
        double headshotRatio = totalKills > 0 ? ((double) totalHeadshots / totalKills) * 100 : 0;
        double killsPorPartida = totalPartidas > 0 ? (double) totalKills / totalPartidas : 0;
        double assistenciasPorPartida = totalPartidas > 0 ? (double) totalAssistencias / totalPartidas : 0;

        String estiloDeJogo;
        if (headshotRatio > 40 && killsPorPartida > 15) {
            estiloDeJogo = "Aim God";
        } else if (killsPorPartida > 20) {
            estiloDeJogo = "Executor";
        } else if (assistenciasPorPartida > 10) {
            estiloDeJogo = "Garçom";
        } else {
            estiloDeJogo = "Versátil";
        }

        double overallScore = (vitoriaRatio * 0.5) + (kdRatio * 10) + (headshotRatio * 0.15) + (killsPorPartida * 1.5);
        int overallRating = Math.max(40, Math.min(99, (int) overallScore));

        card.setVitorias(totalVitorias);
        card.setDerrotas(totalDerrotas);
        card.setKills(totalKills);
        card.setAssistencias(totalAssistencias);
        card.setHeadshots(totalHeadshots);
        card.setKdRatio(Math.round(kdRatio * 100.0) / 100.0);
        card.setPartidasJogadas(totalPartidas);
        card.setOverallRating(overallRating);
        card.setEstiloDeJogo(estiloDeJogo);

        return card;
    }

    private ComparacaoDTO getDadosAgregadosDoUsuario(int usuarioId) {
        UsuariosModel usuario = usuariosRepository.searchByCode(usuarioId);

        if (usuario == null) {
            throw new IllegalArgumentException("Usuário com ID " + usuarioId + " não encontrado.");
        }

        List<EstatisticasModel> estatisticas = estatisticasRepository.findByUsuariosModelIdAndStsProvacao(usuarioId, 1);
        ComparacaoDTO dto = new ComparacaoDTO(usuario.getNickname());

        dto.setTotalPartidas(estatisticas.stream().mapToLong(EstatisticasModel::getQtdPartidas).sum());
        dto.setTotalVitorias(estatisticas.stream().mapToLong(EstatisticasModel::getVitorias).sum());
        dto.setTotalDerrotas(estatisticas.stream().mapToLong(EstatisticasModel::getDerrotas).sum());
        dto.setTotalKills(estatisticas.stream().mapToLong(EstatisticasModel::getKills).sum());
        dto.setTotalAssistencias(estatisticas.stream().mapToLong(EstatisticasModel::getAssistencias).sum());

        long totalDeaths = dto.getTotalDerrotas();
        if (totalDeaths == 0) {
            dto.setKdRatio((double) dto.getTotalKills());
        } else {
            dto.setKdRatio((double) dto.getTotalKills() / totalDeaths);
        }

        return dto;
    }
}