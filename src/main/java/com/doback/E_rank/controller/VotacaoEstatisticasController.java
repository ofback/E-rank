package com.doback.E_rank.controller;

import com.doback.E_rank.facade.UsuariosFacade;
import com.doback.E_rank.facade.VotacaoEstatisticasFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/votacao")
public class VotacaoEstatisticasController {

    private final VotacaoEstatisticasFacade votacaoFacade;
    private final UsuariosFacade usuarioFacade;

    public VotacaoEstatisticasController(VotacaoEstatisticasFacade votacaoFacade, UsuariosFacade usuarioFacade) {
        this.votacaoFacade = votacaoFacade;
        this.usuarioFacade = usuarioFacade;
    }

    // Endpoint: POST /votacao/desafio/{id}/validar
    @PostMapping("/desafio/{id}/validar")
    public ResponseEntity<Void> validarDesafio(
            @PathVariable("id") int desafioId,
            @RequestBody Map<String, Object> payload) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        int usuarioId = usuarioFacade.buscarUsuarioPorEmail(auth.getName()).getId();

        boolean aprovado = (boolean) payload.get("aprovado");
        String motivo = (String) payload.getOrDefault("motivo", "");

        votacaoFacade.validarResultado(desafioId, usuarioId, aprovado, motivo);

        return ResponseEntity.ok().build();
    }
}