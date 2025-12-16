package com.doback.E_rank.controller;

import com.doback.E_rank.dto.FriendDTO;
import com.doback.E_rank.dto.FriendRequestDTO;
import com.doback.E_rank.dto.PendingRequestDTO;
import com.doback.E_rank.dto.UpdateFriendshipStatusDTO;
import com.doback.E_rank.facade.AmizadesFacade;
import com.doback.E_rank.facade.UsuariosFacade;
import com.doback.E_rank.infrastructure.models.AmizadesModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/{id}")
    public AmizadesModel obterAmizade(@PathVariable int id) {
        return amizadeFacade.buscarAmizadePorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAmizade(@RequestBody FriendRequestDTO friendRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String emailRemetente = authentication.getName();
        var remetente = usuarioFacade.buscarUsuarioPorEmail(emailRemetente);
        amizadeFacade.salvarAmizade(remetente.getId(), friendRequest.getIdUsuario2());
    }

    @GetMapping("/meus-amigos")
    public List<FriendDTO> getMeusAmigos() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        var usuario = usuarioFacade.buscarUsuarioPorEmail(email);
        return amizadeFacade.listarAmigos(usuario.getId());
    }

    @GetMapping("/convites")
    public List<PendingRequestDTO> getConvitesPendentes() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        var usuario = usuarioFacade.buscarUsuarioPorEmail(email);
        return amizadeFacade.listarConvitesPendentes(usuario.getId());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> responderAmizade(@PathVariable int id, @RequestBody UpdateFriendshipStatusDTO statusDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        var usuario = usuarioFacade.buscarUsuarioPorEmail(email);

        if (statusDTO.getStatus() == 'A') {
            amizadeFacade.aceitarAmizade(id, usuario.getId());
        } else {
            throw new IllegalArgumentException("Ação não suportada. Use DELETE para recusar.");
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirAmizade(@PathVariable int id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        var usuario = usuarioFacade.buscarUsuarioPorEmail(email);
        amizadeFacade.excluirAmizade(id, usuario.getId());
    }
}