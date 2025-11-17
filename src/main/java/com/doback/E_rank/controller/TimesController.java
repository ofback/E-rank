package com.doback.E_rank.controller;

import com.doback.E_rank.application.TimesApplication;
import com.doback.E_rank.dto.*;
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

    // Application não é mais estritamente necessária aqui se tudo passar pela Facade,
    // mas mantive para compatibilidade caso queira usar.
    private final TimesApplication timesApplication;

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
        return timesFacade.listarTimesDoUsuario(getUsuarioLogadoId());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarTimes(@RequestBody CreateTeamDTO teamDTO) {
        timesFacade.salvarTimes(teamDTO, getUsuarioLogadoId());
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

    // --- NOVOS ENDPOINTS RF08 ---

    // 1. Listar Membros
    @GetMapping("/{id}/members")
    public ResponseEntity<List<TeamMemberDTO>> listarMembros(@PathVariable int id) {
        return ResponseEntity.ok(timesFacade.listarMembros(id));
    }

    // 2. Adicionar Membro
    @PostMapping("/{id}/members")
    public ResponseEntity<Void> adicionarMembro(@PathVariable int id, @RequestBody AddMemberDTO dto) {
        timesFacade.adicionarMembro(id, dto.getUserId());
        return ResponseEntity.ok().build();
    }

    // 3. Alterar Cargo (Ex: Tornar ViceLider)
    @PatchMapping("/{id}/members/{userId}/role")
    public ResponseEntity<Void> alterarCargo(@PathVariable int id,
                                             @PathVariable int userId,
                                             @RequestBody UpdateRoleDTO roleDTO) {
        timesFacade.alterarCargo(id, userId, roleDTO.getNovoCargo(), getUsuarioLogadoId());
        return ResponseEntity.ok().build();
    }

    // 4. Remover Membro (Expulsar ou Sair)
    // Atualiza o antigo endpoint para permitir expulsão se for Dono/Vice
    @DeleteMapping("/{teamId}/members/{userId}")
    public ResponseEntity<Void> removeMember(@PathVariable int teamId, @PathVariable int userId) {
        // A lógica de permissão foi movida para dentro da Application
        // Passamos o ID de quem está chamando a API para validação
        timesFacade.removerMembro(teamId, userId, getUsuarioLogadoId());
        return ResponseEntity.noContent().build();
    }

    // --- Helper Privado ---
    private int getUsuarioLogadoId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return usuarioFacade.buscarUsuarioPorEmail(email).getId();
    }
}