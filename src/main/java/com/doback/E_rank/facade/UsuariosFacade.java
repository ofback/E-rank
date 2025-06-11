package com.doback.E_rank.facade;

import com.doback.E_rank.application.UsuariosApplication;
import com.doback.E_rank.models.UsuariosModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuariosFacade {
    private final UsuariosApplication usuarioApplication;

    public UsuariosFacade(UsuariosApplication usuarioApplication) {
        this.usuarioApplication = usuarioApplication;
    }

    public List<UsuariosModel> listarUsuarios() {
        return usuarioApplication.obterTodosUsuarios();
    }

    public UsuariosModel buscarUsuarioPorId(int id) {
        return usuarioApplication.obterUsuarioPorId(id);
    }

    // O nome do método aqui é 'salvarUsuario', ele chama 'criarUsuario' na camada de aplicação. Está correto.
    public void salvarUsuario(UsuariosModel usuario) {
        usuarioApplication.criarUsuario(usuario);
    }

    public void excluirUsuario(int id) {
        usuarioApplication.excluirUsuario(id);
    }

    public void atualizarUsuarios(int id, UsuariosModel usuariosModel) {
        usuarioApplication.atualizarUsuarios(id, usuariosModel);
    }
}