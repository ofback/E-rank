package com.doback.E_rank.controller;

import com.doback.E_rank.entity.Usuario;
import com.doback.E_rank.application.UsuarioApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioApplication usuarioApplication;

    public UsuarioController(UsuarioApplication usuarioApplication) {
        this.usuarioApplication = usuarioApplication;
    }


    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioApplication.obterTodosUsuarios();
    }


    @GetMapping("/{id}")
    public Optional<Usuario> obterUsuario(@PathVariable Long id) {
        return usuarioApplication.obterUsuarioPorId(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario criarUsuario(@RequestBody Usuario usuario) {
        return usuarioApplication.criarUsuario(usuario);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirUsuario(@PathVariable Long id) {
        usuarioApplication.excluirUsuario(id);
    }
}
