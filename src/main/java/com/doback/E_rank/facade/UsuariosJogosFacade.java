package com.doback.E_rank.facade;

import com.doback.E_rank.application.UsuariosJogosApplication;
import com.doback.E_rank.entity.UsuariosJogos;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class UsuariosJogosFacade {
    private final UsuariosJogosApplication usuariosJogosApplication;

    public UsuariosJogosFacade(UsuariosJogosApplication usuariosJogosApplication) {
        this.usuariosJogosApplication = usuariosJogosApplication;
    }

    public List<UsuariosJogos> listarUsuariosJogos() {
        return usuariosJogosApplication.obterTodosUsuariosJogos();
    }

    public UsuariosJogos buscarUsuariosJogosPorId(int id) {
        return usuariosJogosApplication.obterUsuariosJogosPorId(id);
    }

    public void salvarUsuariosJogos(UsuariosJogos usuariosJogos) {
        usuariosJogosApplication.criarUsuariosJogos(usuariosJogos);
    }

    public void excluirUsuariosJogos(int id) {
        usuariosJogosApplication.excluirUsuariosJogos(id);
    }

    public void atualizarUsuariosJogos(int id, UsuariosJogos usuariosJogos) {
        usuariosJogosApplication.atualizarUsuariosJogos(id, usuariosJogos);
    }
}
