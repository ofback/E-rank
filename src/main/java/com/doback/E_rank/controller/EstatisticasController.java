package com.doback.E_rank.controller;

import com.doback.E_rank.dto.CreateEstatisticaDTO;
import com.doback.E_rank.facade.EstatisticasFacade;
import com.doback.E_rank.facade.UsuariosFacade;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estatisticas")
public class EstatisticasController {

    private final EstatisticasFacade estatisticasFacade;
    private final UsuariosFacade usuarioFacade;

    public EstatisticasController(EstatisticasFacade estatisticasFacade, UsuariosFacade usuarioFacade) {
        this.estatisticasFacade = estatisticasFacade;
        this.usuarioFacade = usuarioFacade;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void registrar(@RequestBody CreateEstatisticaDTO dto) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        int userId = usuarioFacade.buscarUsuarioPorEmail(auth.getName()).getId();

        estatisticasFacade.registrar(dto, userId);
    }
}