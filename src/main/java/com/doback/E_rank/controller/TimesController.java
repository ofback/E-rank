package com.doback.E_rank.controller;

import com.doback.E_rank.dto.CreateTeamDTO;
import com.doback.E_rank.facade.TimesFacade;
import com.doback.E_rank.facade.UsuariosFacade;
import com.doback.E_rank.infrastructure.models.TimesModel;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/times")
public class TimesController {

    private final TimesFacade timesFacade;
    private final UsuariosFacade usuarioFacade; // Injeção necessária

    // Construtor atualizado
    public TimesController(TimesFacade timesFacade, UsuariosFacade usuarioFacade) {
        this.timesFacade = timesFacade;
        this.usuarioFacade = usuarioFacade;
    }

    @GetMapping
    public List<TimesModel> listarTimes() {
        return timesFacade.listarTimes();
    }

    @GetMapping("/{id}")
    public TimesModel obterTimes(@PathVariable int id) {
        return timesFacade.buscarTimesPorId(id);
    }

    // ENDPOINT ATUALIZADO para usar o DTO e o usuário autenticado
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarTimes(@RequestBody CreateTeamDTO teamDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        var usuario = usuarioFacade.buscarUsuarioPorEmail(email);

        timesFacade.salvarTimes(teamDTO, usuario.getId());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirTimes(@PathVariable int id) {
        timesFacade.excluirTimes(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizarTimes(@PathVariable int id,@RequestBody TimesModel timesModel){
        timesFacade.atualizarTimes(id, timesModel);
    }
}
