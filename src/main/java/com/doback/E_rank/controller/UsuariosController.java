package com.doback.E_rank.controller;

import com.doback.E_rank.dto.CreateUsuarioDTO;
import com.doback.E_rank.dto.UpdateProfileDTO;
import com.doback.E_rank.dto.UsuarioResponseDTO;
import com.doback.E_rank.infrastructure.models.UsuariosModel;
import com.doback.E_rank.facade.UsuariosFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    private final UsuariosFacade usuarioFacade;

    public UsuariosController(UsuariosFacade usuarioFacade) {
        this.usuarioFacade = usuarioFacade;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listarUsuarios(@RequestParam Optional<String> nickname) {
        if (nickname.isPresent()) {
            return ResponseEntity.ok(usuarioFacade.listarUsuariosPorNickname(nickname.get()));
        }
        return ResponseEntity.ok(usuarioFacade.listarUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> obterUsuario(@PathVariable int id) {
        return ResponseEntity.ok(usuarioFacade.buscarUsuarioPorId(id));
    }

    @GetMapping("/me")
    public ResponseEntity<UsuarioResponseDTO> getUsuarioLogado() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return ResponseEntity.ok(usuarioFacade.buscarUsuarioPorEmail(email));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarUsuario(@RequestBody CreateUsuarioDTO usuarioDTO) {
        // Recebe DTO Seguro
        usuarioFacade.salvarUsuario(usuarioDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirUsuario(@PathVariable int id) {
        usuarioFacade.excluirUsuario(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizarUsuario(@PathVariable int id, @RequestBody UsuariosModel usuariosModel){
        usuarioFacade.atualizarUsuarios(id, usuariosModel);
    }

    @PutMapping("/me")
    public ResponseEntity<Void> atualizarUsuarioLogado(@RequestBody UpdateProfileDTO profileDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        usuarioFacade.atualizarPerfil(email, profileDTO);
        return ResponseEntity.ok().build();
    }
}