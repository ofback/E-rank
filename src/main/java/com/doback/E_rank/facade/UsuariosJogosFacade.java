package com.doback.E_rank.facade;

import com.doback.E_rank.application.UsuariosJogosApplication;
import com.doback.E_rank.infrastructure.models.UsuariosJogosModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class UsuariosJogosFacade {
    private final UsuariosJogosApplication usuariosJogosApplication;

    public UsuariosJogosFacade(UsuariosJogosApplication usuariosJogosApplication) {
        this.usuariosJogosApplication = usuariosJogosApplication;
    }

    public List<UsuariosJogosModel> listarUsuariosJogos() {
        return usuariosJogosApplication.obterTodosUsuariosJogos();
    }

    public UsuariosJogosModel buscarUsuariosJogosPorId(int id) {
        return usuariosJogosApplication.obterUsuariosJogosPorId(id);
    }

    public void salvarUsuariosJogos(UsuariosJogosModel usuariosJogosModel) {
        usuariosJogosApplication.criarUsuariosJogos(usuariosJogosModel);
    }

    public void excluirUsuariosJogos(int id) {
        usuariosJogosApplication.excluirUsuariosJogos(id);
    }

    public void atualizarUsuariosJogos(int id, UsuariosJogosModel usuariosJogosModel) {
        usuariosJogosApplication.atualizarUsuariosJogos(id, usuariosJogosModel);
    }
}
