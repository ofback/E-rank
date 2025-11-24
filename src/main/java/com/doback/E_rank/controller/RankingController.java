package com.doback.E_rank.controller;

import com.doback.E_rank.dto.ComparacaoDTO;
import com.doback.E_rank.dto.PlayerCardDTO;
import com.doback.E_rank.dto.RankingDTO;
import com.doback.E_rank.facade.RankingFacade;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rankings")
public class RankingController {

    private final RankingFacade rankingFacade;

    public RankingController(RankingFacade rankingFacade) {
        this.rankingFacade = rankingFacade;
    }

    @GetMapping("/global")
    public ResponseEntity<Page<RankingDTO>> getRankingGlobal(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        return ResponseEntity.ok(rankingFacade.getRankingGlobal(page, size));
    }

    @GetMapping("/jogo/{jogoId}")
    public List<RankingDTO> getRankingPorJogo(@PathVariable int jogoId) {
        return rankingFacade.getRankingPorJogo(jogoId);
    }

    @GetMapping("/compare")
    public List<ComparacaoDTO> compararJogadores(@RequestParam List<Integer> userIds) {
        if (userIds == null || userIds.size() < 2) {
            throw new IllegalArgumentException("Forneça pelo menos dois IDs de usuário para comparar.");
        }
        return rankingFacade.compararJogadores(userIds);
    }

    @GetMapping("/player/{userId}/card")
    public PlayerCardDTO getPlayerCard(@PathVariable int userId) {
        return rankingFacade.getPlayerCard(userId);
    }
}