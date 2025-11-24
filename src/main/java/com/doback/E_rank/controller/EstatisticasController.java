package com.doback.E_rank.controller;

import com.doback.E_rank.dto.CreateEstatisticaDTO;
import com.doback.E_rank.dto.PlayerCardDTO;
import com.doback.E_rank.facade.EstatisticasFacade;
import com.doback.E_rank.facade.RankingFacade; // Import adicionado
import com.doback.E_rank.facade.UsuariosFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estatisticas")
public class EstatisticasController {

    private final EstatisticasFacade estatisticasFacade;
    private final UsuariosFacade usuarioFacade;
    private final RankingFacade rankingFacade; // Campo adicionado

    // Construtor atualizado recebendo RankingFacade
    public EstatisticasController(EstatisticasFacade estatisticasFacade,
                                  UsuariosFacade usuarioFacade,
                                  RankingFacade rankingFacade) {
        this.estatisticasFacade = estatisticasFacade;
        this.usuarioFacade = usuarioFacade;
        this.rankingFacade = rankingFacade;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void registrar(@RequestBody CreateEstatisticaDTO dto) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        int userId = usuarioFacade.buscarUsuarioPorEmail(auth.getName()).getId();

        estatisticasFacade.registrar(dto, userId);
    }

    @GetMapping("/me/card")
    public ResponseEntity<PlayerCardDTO> getMyCard() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        // Busca o ID do usuário logado
        int userId = usuarioFacade.buscarUsuarioPorEmail(auth.getName()).getId();
        // Reutiliza a lógica do RankingFacade
        return ResponseEntity.ok(rankingFacade.getPlayerCard(userId));
    }
}