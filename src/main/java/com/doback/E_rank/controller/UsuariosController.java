package com.doback.E_rank.controller;

import com.doback.E_rank.infrastructure.models.UsuariosModel;
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
    public List<UsuariosModel> listarUsuarios() {
        return usuarioFacade.listarUsuarios();
    }

    @GetMapping("/{id}")
    public UsuariosModel obterUsuario(@PathVariable int id) {
        return usuarioFacade.buscarUsuarioPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarUsuario(@RequestBody UsuariosModel usuario) {
        usuarioFacade.salvarUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirUsuario(@PathVariable int id) {
        usuarioFacade.excluirUsuario(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizarUsuario(@PathVariable int id,@RequestBody UsuariosModel usuariosModel){
        usuarioFacade.atualizarUsuarios(id, usuariosModel);
    }
}
