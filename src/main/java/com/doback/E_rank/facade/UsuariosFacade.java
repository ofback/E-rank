package com.doback.E_rank.facade;

import com.doback.E_rank.application.UsuariosApplication;
import com.doback.E_rank.models.Usuarios;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuariosFacade {
    private final UsuariosApplication usuarioApplication;

    public UsuariosFacade(UsuariosApplication usuarioApplication) {
        this.usuarioApplication = usuarioApplication;
    }

    public List<Usuarios> listarUsuarios() {
        return usuarioApplication.obterTodosUsuarios();
    }

    public Usuarios buscarUsuarioPorId(int id) {
        return usuarioApplication.obterUsuarioPorId(id);
    }

    public void salvarUsuario(Usuarios usuario) {
        usuarioApplication.criarUsuario(usuario);
    }

    public void excluirUsuario(int id) {
        usuarioApplication.excluirUsuario(id);
    }

    public void atualizarUsuarios(int id, Usuarios usuarios) {
        usuarioApplication.atualizarUsuarios(id, usuarios);
    }
}
