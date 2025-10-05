package com.doback.E_rank.controller;

import com.doback.E_rank.dto.FriendDTO;
import com.doback.E_rank.dto.FriendRequestDTO;
import com.doback.E_rank.dto.PendingRequestDTO;
import com.doback.E_rank.facade.AmizadesFacade;
import com.doback.E_rank.facade.UsuariosFacade;
import com.doback.E_rank.infrastructure.models.AmizadesModel;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/amizades")
public class AmizadesController {

    private final AmizadesFacade amizadeFacade;
    private final UsuariosFacade usuarioFacade;

    public AmizadesController(AmizadesFacade amizadeFacade, UsuariosFacade usuarioFacade) {
        this.amizadeFacade = amizadeFacade;
        this.usuarioFacade = usuarioFacade;
    }

    @GetMapping
    public List<AmizadesModel> listarAmizades() {
        return amizadeFacade.listarAmizades();
    }

    @GetMapping("/{id}")
    public AmizadesModel obterAmizade(@PathVariable int id) {
        return amizadeFacade.buscarAmizadePorId(id);
    }

    @GetMapping("/meus-amigos")
    public List<FriendDTO> getMeusAmigos() { // TIPO DE RETORNO CORRIGIDO
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        var usuario = usuarioFacade.buscarUsuarioPorEmail(email);
        return amizadeFacade.listarAmigos(usuario.getId());
    }

    @GetMapping("/convites")
    public List<PendingRequestDTO> getConvitesPendentes() { // TIPO DE RETORNO CORRIGIDO
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        var usuario = usuarioFacade.buscarUsuarioPorEmail(email);
        return amizadeFacade.listarConvitesPendentes(usuario.getId());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAmizade(@RequestBody FriendRequestDTO friendRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String emailRemetente = authentication.getName();
        var remetente = usuarioFacade.buscarUsuarioPorEmail(emailRemetente);
        amizadeFacade.salvarAmizade(remetente.getId(), friendRequest.getIdUsuario2());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirAmizade(@PathVariable int id) {
        amizadeFacade.excluirAmizade(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizarAmizades(@PathVariable int id, @RequestBody AmizadesModel amizadesModel) {
        amizadeFacade.atualizarAmizades(id, amizadesModel);
    }
}

