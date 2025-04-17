package com.doback.E_rank.application;

import com.doback.E_rank.models.UsuariosJogos;
import com.doback.E_rank.interfaces.UsuariosJogosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosJogosApplication {
    private final UsuariosJogosRepository usuariosJogosRepository;

    public UsuariosJogosApplication(UsuariosJogosRepository usuariosJogosRepository) {
        this.usuariosJogosRepository = usuariosJogosRepository;
    }

    public List<UsuariosJogos> obterTodosUsuariosJogos() {
        return usuariosJogosRepository.buscar();
    }

    public UsuariosJogos obterUsuariosJogosPorId(int id) {
        return usuariosJogosRepository.searchByCode(id);
    }

    public void criarUsuariosJogos(UsuariosJogos usuariosJogos) {
        usuariosJogosRepository.addUsuariosJogos(usuariosJogos);
    }

    public void excluirUsuariosJogos(int id) {
        usuariosJogosRepository.removeUsuariosJogos(id);
    }

    public void atualizarUsuariosJogos(int id, UsuariosJogos usuariosJogos) {
        usuariosJogosRepository.updateUsuariosJogos(id, usuariosJogos);
    }
}
