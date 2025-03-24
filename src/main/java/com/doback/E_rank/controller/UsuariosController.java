package com.doback.E_rank.controller;

import com.doback.E_rank.entity.Usuarios;
import com.doback.E_rank.facade.UsuariosFacade;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    private final UsuariosFacade usuarioFacade;

    public UsuariosController(UsuariosFacade usuarioFacade) {
        this.usuarioFacade = usuarioFacade;
    }

    @GetMapping
    public List<Usuarios> listarUsuarios() {
        return usuarioFacade.listarUsuarios();
    }

    @GetMapping("/{id}")
    public Usuarios obterUsuario(@PathVariable int id) {
        return usuarioFacade.buscarUsuarioPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarUsuario(@RequestBody Usuarios usuario) {
        usuarioFacade.salvarUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirUsuario(@PathVariable int id) {
        usuarioFacade.excluirUsuario(id);
    }
}
