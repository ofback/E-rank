package com.doback.E_rank.application;

import com.doback.E_rank.dto.ComparacaoDTO;
import com.doback.E_rank.dto.PlayerCardDTO;
import com.doback.E_rank.dto.RankingDTO;
import com.doback.E_rank.infrastructure.models.EstatisticasModel;
import com.doback.E_rank.infrastructure.models.UsuariosModel;
import com.doback.E_rank.interfaces.EstatisticasRepository;
import com.doback.E_rank.interfaces.UsuariosRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RankingApplication {

    private final EstatisticasRepository estatisticasRepository;
    private final UsuariosRepository usuariosRepository;

    public RankingApplication(EstatisticasRepository estatisticasRepository, UsuariosRepository usuariosRepository) {
        this.estatisticasRepository = estatisticasRepository;
        this.usuariosRepository = usuariosRepository;
    }

    /**
     * Lógica para o RF16: Gera um ranking para um jogo específico.
     */
    public List<RankingDTO> getRankingPorJogo(int jogoId) {
        List<EstatisticasModel> estatisticasAprovadas = estatisticasRepository.findAprovadasPorJogo(jogoId);

        List<RankingDTO> ranking = new ArrayList<>();

        for (EstatisticasModel est : estatisticasAprovadas) {
            UsuariosModel usuario = usuariosRepository.searchByCode((long) est.getIdUsuario());
            if (usuario != null) {
                // Fórmula de pontuação simples para o MVP
                int pontuacao = (est.getVitorias() * 10) + (est.getKills() * 2) - (est.getDerrotas() * 5);
                ranking.add(new RankingDTO(0, usuario.getNickname(), pontuacao, est.getVitorias(), est.getKills()));
            }
        }

        // Ordena o ranking pela pontuação, do maior para o menor
        ranking.sort(Comparator.comparingInt(RankingDTO::getPontuacao).reversed());

        // Atribui a posição correta após a ordenação
        for (int i = 0; i < ranking.size(); i++) {
            ranking.get(i).setPosicao(i + 1);
        }

        return ranking;
    }

    /**
     * Lógica para o RF17: Compara o desempenho de múltiplos jogadores.
     */
    public List<ComparacaoDTO> compararJogadores(List<Integer> userIds) {
        return userIds.stream()
                .map(this::getDadosAgregadosDoUsuario)
                .collect(Collectors.toList());
    }

    /**
     * Gera os dados para a "carta" de um jogador individual com estilo de jogo.
     */
    public PlayerCardDTO getPlayerCard(int userId) {
        UsuariosModel usuario = usuariosRepository.searchByCode((long) userId);
        if (usuario == null) {
            throw new IllegalArgumentException("Usuário com ID " + userId + " não encontrado.");
        }

        List<EstatisticasModel> estatisticas = estatisticasRepository.findAprovadasPorUsuario(userId);
        PlayerCardDTO card = new PlayerCardDTO(usuario.getNickname(), usuario.getNome());

        // 1. Agrega todos os dados do jogador
        long totalPartidas = estatisticas.stream().mapToLong(EstatisticasModel::getQtdPartidas).sum();
        long totalVitorias = estatisticas.stream().mapToLong(EstatisticasModel::getVitorias).sum();
        long totalDerrotas = estatisticas.stream().mapToLong(EstatisticasModel::getDerrotas).sum();
        long totalKills = estatisticas.stream().mapToLong(EstatisticasModel::getKills).sum();
        long totalAssistencias = estatisticas.stream().mapToLong(EstatisticasModel::getAssistencias).sum();
        long totalHeadshots = estatisticas.stream().mapToLong(EstatisticasModel::getHeadshots).sum();
        long totalDeaths = totalDerrotas == 0 ? 1 : totalDerrotas; // Evita divisão por zero no K/D

        // 2. Calcula as métricas de performance
        double kdRatio = (double) totalKills / totalDeaths;
        double vitoriaRatio = totalPartidas > 0 ? ((double) totalVitorias / totalPartidas) * 100 : 0;
        double headshotRatio = totalKills > 0 ? ((double) totalHeadshots / totalKills) * 100 : 0;
        double killsPorPartida = totalPartidas > 0 ? (double) totalKills / totalPartidas : 0;
        double assistenciasPorPartida = totalPartidas > 0 ? (double) totalAssistencias / totalPartidas : 0;

        // 3. Define o Estilo de Jogo com base nas métricas
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

        // 4. Calcula o Overall Rating (0-99) com a nova fórmula
        double overallScore = (vitoriaRatio * 0.5) + (kdRatio * 10) + (headshotRatio * 0.15) + (killsPorPartida * 1.5);
        int overallRating = Math.max(40, Math.min(99, (int) overallScore)); // Garante que o rating fique entre 40 e 99

        // 5. Preenche o DTO com todos os dados
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
        UsuariosModel usuario = usuariosRepository.searchByCode((long) usuarioId);
        if (usuario == null) {
            throw new IllegalArgumentException("Usuário com ID " + usuarioId + " não encontrado.");
        }

        List<EstatisticasModel> estatisticas = estatisticasRepository.findAprovadasPorUsuario(usuarioId);
        ComparacaoDTO dto = new ComparacaoDTO(usuario.getNickname());

        dto.setTotalPartidas(estatisticas.stream().mapToLong(EstatisticasModel::getQtdPartidas).sum());
        dto.setTotalVitorias(estatisticas.stream().mapToLong(EstatisticasModel::getVitorias).sum());
        dto.setTotalDerrotas(estatisticas.stream().mapToLong(EstatisticasModel::getDerrotas).sum());
        dto.setTotalKills(estatisticas.stream().mapToLong(EstatisticasModel::getKills).sum());
        dto.setTotalAssistencias(estatisticas.stream().mapToLong(EstatisticasModel::getAssistencias).sum());

        long totalDeaths = dto.getTotalDerrotas();
        if (totalDeaths == 0) {
            dto.setKdRatio(dto.getTotalKills());
        } else {
            dto.setKdRatio((double) dto.getTotalKills() / totalDeaths);
        }

        return dto;
    }
}

