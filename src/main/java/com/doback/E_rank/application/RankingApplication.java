package com.doback.E_rank.application;

import com.doback.E_rank.dto.ComparacaoDTO;
import com.doback.E_rank.dto.PlayerCardDTO;
import com.doback.E_rank.dto.RankingDTO;
import com.doback.E_rank.infrastructure.models.AmizadesModel;
import com.doback.E_rank.infrastructure.models.EstatisticasModel;
import com.doback.E_rank.infrastructure.models.UsuariosModel;
import com.doback.E_rank.infrastructure.repository.jpa.AmizadesJpa;
import com.doback.E_rank.infrastructure.repository.jpa.EstatisticasJpa;
import com.doback.E_rank.interfaces.UsuariosRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RankingApplication {

    private final EstatisticasJpa estatisticasRepository;
    private final UsuariosRepository usuariosRepository;
    private final AmizadesJpa amizadesJpa;

    public RankingApplication(EstatisticasJpa estatisticasRepository,
                              UsuariosRepository usuariosRepository,
                              AmizadesJpa amizadesJpa) {
        this.estatisticasRepository = estatisticasRepository;
        this.usuariosRepository = usuariosRepository;
        this.amizadesJpa = amizadesJpa;
    }

    public Page<RankingDTO> getRankingGlobal(int page, int size) {
        if (page < 0) page = 0;
        return estatisticasRepository.buscarRankingGlobal(PageRequest.of(page, size));
    }

    public Page<RankingDTO> getRankingAmigos(int usuarioId, int page, int size) {
        if (page < 0) page = 0;

        // 1. Busca amizades ativas
        List<AmizadesModel> amizades = amizadesJpa.findByIdUsuario1AndStatusOrIdUsuario2AndStatus(usuarioId, 'A', usuarioId, 'A');

        // 2. Cria lista de IDs
        List<Integer> idsParaRanking = new ArrayList<>();
        idsParaRanking.add(usuarioId);

        for (AmizadesModel amizade : amizades) {
            if (amizade.getIdUsuario1() == usuarioId) {
                idsParaRanking.add(amizade.getIdUsuario2());
            } else {
                idsParaRanking.add(amizade.getIdUsuario1());
            }
        }

        // 3. Busca ranking filtrado
        return estatisticasRepository.buscarRankingPorIds(idsParaRanking, PageRequest.of(page, size));
    }

    public List<RankingDTO> getRankingPorJogo(int jogoId) {
        // Placeholder simples para evitar erro, caso precise expandir depois
        return new ArrayList<>();
    }

    public List<ComparacaoDTO> compararJogadores(List<Integer> userIds) {
        List<ComparacaoDTO> comparacoes = new ArrayList<>();
        for (Integer id : userIds) {
            comparacoes.add(getDadosAgregadosDoUsuario(id));
        }
        return comparacoes;
    }

    public PlayerCardDTO getPlayerCard(int userId) {
        ComparacaoDTO dados = getDadosAgregadosDoUsuario(userId);

        PlayerCardDTO card = new PlayerCardDTO();
        card.setNickname(dados.getNickname());
        card.setNome(dados.getNome());

        // CORREÇÃO: Usando os setters corretos definidos no PlayerCardDTO
        // O DTO usa nomes diretos (vitorias, derrotas, kills) e não 'setTotalX'
        card.setPartidasJogadas(dados.getTotalPartidas());
        card.setVitorias(dados.getTotalVitorias());
        card.setDerrotas(dados.getTotalDerrotas());
        card.setKills(dados.getTotalKills());
        card.setAssistencias(dados.getTotalAssistencias());

        // Cálculos de Rating e Estilo
        card.setKdRatio(dados.getKdRatio());

        // Exemplo simples de cálculo de Overall (Soma ponderada)
        long score = (dados.getTotalVitorias() * 10) + (dados.getTotalKills() * 2);
        card.setOverallRating((int) Math.min(score, 9999)); // Limite seguro

        // Lógica simples para estilo de jogo
        if (dados.getTotalKills() > dados.getTotalAssistencias() * 2) {
            card.setEstiloDeJogo("Agressivo");
        } else if (dados.getTotalAssistencias() > dados.getTotalKills()) {
            card.setEstiloDeJogo("Suporte");
        } else {
            card.setEstiloDeJogo("Tático");
        }

        return card;
    }

    // --- MÉTODO AUXILIAR QUE ESTAVA FALTANDO ---
    private ComparacaoDTO getDadosAgregadosDoUsuario(int usuarioId) {
        UsuariosModel user = usuariosRepository.searchByCode(usuarioId);
        if (user == null) {
            throw new IllegalArgumentException("Usuário não encontrado: " + usuarioId);
        }

        // Busca estatísticas aprovadas (stsProvacao = 1)
        List<EstatisticasModel> stats = estatisticasRepository.findByUsuariosModelIdAndStsProvacao(usuarioId, 1);

        long vitorias = stats.stream().filter(EstatisticasModel::isResultadoVitoria).count();
        long derrotas = stats.size() - vitorias;
        long kills = stats.stream().mapToLong(EstatisticasModel::getKills).sum();
        long assistencias = stats.stream().mapToLong(EstatisticasModel::getAssistencias).sum();

        ComparacaoDTO dto = new ComparacaoDTO();
        dto.setNickname(user.getNickname());
        dto.setNome(user.getNome()); // Agora existe no DTO
        dto.setTotalPartidas(stats.size());
        dto.setTotalVitorias(vitorias);
        dto.setTotalDerrotas(derrotas);
        dto.setTotalKills(kills);
        dto.setTotalAssistencias(assistencias);

        // Cálculo seguro de K/D
        double kd = (derrotas == 0) ? kills : (double) kills / derrotas;
        dto.setKdRatio(Math.round(kd * 100.0) / 100.0);

        return dto;
    }
}