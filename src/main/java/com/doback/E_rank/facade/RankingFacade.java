package com.doback.E_rank.facade;

import com.doback.E_rank.application.RankingApplication;
import com.doback.E_rank.dto.ComparacaoDTO;
import com.doback.E_rank.dto.PlayerCardDTO;
import com.doback.E_rank.dto.RankingDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RankingFacade {
    private final RankingApplication rankingApplication;

    public RankingFacade(RankingApplication rankingApplication) {
        this.rankingApplication = rankingApplication;
    }

    public Page<RankingDTO> getRankingGlobal(int page, int size) {
        return rankingApplication.getRankingGlobal(page, size);
    }

    public Page<RankingDTO> getRankingAmigos(int usuarioId, int page, int size) {
        return rankingApplication.getRankingAmigos(usuarioId, page, size);
    }

    public List<RankingDTO> getRankingPorJogo(int jogoId) {
        return rankingApplication.getRankingPorJogo(jogoId);
    }

    public List<ComparacaoDTO> compararJogadores(List<Integer> userIds) {
        return rankingApplication.compararJogadores(userIds);
    }

    public PlayerCardDTO getPlayerCard(int userId) {
        return rankingApplication.getPlayerCard(userId);
    }
}