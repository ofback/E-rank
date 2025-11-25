package com.doback.E_rank.controller;

import com.doback.E_rank.dto.ComparacaoDTO;
import com.doback.E_rank.dto.PlayerCardDTO;
import com.doback.E_rank.dto.RankingDTO;
import com.doback.E_rank.facade.RankingFacade;
import com.doback.E_rank.facade.UsuariosFacade;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rankings")
public class RankingController {

    private final RankingFacade rankingFacade;
    private final UsuariosFacade usuariosFacade;

    public RankingController(RankingFacade rankingFacade, UsuariosFacade usuariosFacade) {
        this.rankingFacade = rankingFacade;
        this.usuariosFacade = usuariosFacade;
    }

    // Endpoint unificado com filtro
    // Exemplo de chamada: GET /rankings?tipo=AMIGOS&page=0&size=10
    @GetMapping
    public ResponseEntity<Page<RankingDTO>> getRanking(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size,
            @RequestParam(defaultValue = "GLOBAL") String tipo
    ) {
        if ("AMIGOS".equalsIgnoreCase(tipo)) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            // Busca o ID do usuário logado usando o e-mail do token
            int userId = usuariosFacade.buscarUsuarioPorEmail(auth.getName()).getId();

            return ResponseEntity.ok(rankingFacade.getRankingAmigos(userId, page, size));
        }

        // Padrão: Retorna Ranking Global
        return ResponseEntity.ok(rankingFacade.getRankingGlobal(page, size));
    }

    // Mantido para compatibilidade se o front-end antigo usar /global explicitamente,
    // mas redireciona para a lógica padrão.
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

    @PostMapping("/compare")
    public List<ComparacaoDTO> compararJogadores(@RequestBody List<Integer> userIds) {
        if (userIds == null || userIds.size() < 2) {
            throw new IllegalArgumentException("Forneça pelo menos dois IDs de usuário para comparar.");
        }
        return rankingFacade.compararJogadores(userIds);
    }

    @GetMapping("/player/{userId}/card")
    public ResponseEntity<PlayerCardDTO> getPlayerCard(@PathVariable int userId) {
        return ResponseEntity.ok(rankingFacade.getPlayerCard(userId));
    }
}