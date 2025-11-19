package com.doback.E_rank.controller;

import com.doback.E_rank.dto.CreateDesafioDTO;
import com.doback.E_rank.dto.DesafioResponseDTO;
import com.doback.E_rank.facade.DesafiosFacade;
import com.doback.E_rank.facade.UsuariosFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/desafios")
public class DesafiosController {

    private final DesafiosFacade desafiosFacade;
    private final UsuariosFacade usuarioFacade;

    public DesafiosController(DesafiosFacade desafiosFacade, UsuariosFacade usuarioFacade) {
        this.desafiosFacade = desafiosFacade;
        this.usuarioFacade = usuarioFacade;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criar(@RequestBody CreateDesafioDTO dto) {
        desafiosFacade.criar(dto, getUsuarioLogadoId());
    }

    @GetMapping("/pendentes")
    public List<DesafioResponseDTO> listarPendentes() {
        return desafiosFacade.listarPendentes(getUsuarioLogadoId());
    }

    @PatchMapping("/{id}/responder")
    public ResponseEntity<Void> responder(@PathVariable int id, @RequestBody Map<String, Boolean> body) {
        // CORREÇÃO: Verificação de nulidade para evitar erro 500
        Boolean aceitar = body.get("aceitar");
        if (aceitar == null) {
            throw new IllegalArgumentException("O campo 'aceitar' é obrigatório.");
        }

        desafiosFacade.responder(id, getUsuarioLogadoId(), aceitar);
        return ResponseEntity.ok().build();
    }

    private int getUsuarioLogadoId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        // Garanta que o UsuariosFacade tenha o método buscarUsuarioPorEmail
        return usuarioFacade.buscarUsuarioPorEmail(email).getId();
    }
}