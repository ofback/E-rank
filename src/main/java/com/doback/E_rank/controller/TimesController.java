package com.doback.E_rank.controller;

import com.doback.E_rank.application.TimesApplication;
import com.doback.E_rank.dto.CreateTeamDTO;
import com.doback.E_rank.dto.MyTeamDTO;
import com.doback.E_rank.facade.TimesFacade;
import com.doback.E_rank.facade.UsuariosFacade;
import com.doback.E_rank.infrastructure.models.TimesModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/times")
public class TimesController {

    private final TimesFacade timesFacade;
    private final UsuariosFacade usuarioFacade;
    private final TimesApplication timesApplication; // Injetar diretamente para o novo método

    public TimesController(TimesFacade timesFacade, UsuariosFacade usuarioFacade, TimesApplication timesApplication) {
        this.timesFacade = timesFacade;
        this.usuarioFacade = usuarioFacade;
        this.timesApplication = timesApplication;
    }

    @GetMapping
    public List<TimesModel> listarTimes() {
        return timesFacade.listarTimes();
    }

    @GetMapping("/{id}")
    public TimesModel obterTimes(@PathVariable int id) {
        return timesFacade.buscarTimesPorId(id);
    }

    @GetMapping("/me")
    public List<MyTeamDTO> getMeusTimes() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        var usuario = usuarioFacade.buscarUsuarioPorEmail(email);
        return timesFacade.listarTimesDoUsuario(usuario.getId());
    }

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
    public void atualizarTimes(@PathVariable int id, @RequestBody TimesModel timesModel) {
        timesFacade.atualizarTimes(id, timesModel);
    }

    // Adicionado para RF07
    @DeleteMapping("/{teamId}/members/{userId}")
    public ResponseEntity<Void> leaveTeam(@PathVariable int teamId, @PathVariable int userId) {
        // Validação de segurança: Em um cenário real, você verificaria se o usuário autenticado
        // é o mesmo `userId` ou se ele tem permissão para remover outro.
        // Por simplicidade, vamos chamar o serviço diretamente.
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        var usuarioAutenticado = usuarioFacade.buscarUsuarioPorEmail(email);

        if(usuarioAutenticado.getId() != userId) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        timesApplication.leaveTeam(teamId, userId);
        return ResponseEntity.noContent().build();
    }
}