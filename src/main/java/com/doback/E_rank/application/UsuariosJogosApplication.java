package com.doback.E_rank.application;

import com.doback.E_rank.infrastructure.models.UsuariosJogosModel;
import com.doback.E_rank.interfaces.UsuariosJogosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosJogosApplication {
    private final UsuariosJogosRepository usuariosJogosRepository;

    public UsuariosJogosApplication(UsuariosJogosRepository usuariosJogosRepository) {
        this.usuariosJogosRepository = usuariosJogosRepository;
    }

    public List<UsuariosJogosModel> obterTodosUsuariosJogos() {
        return usuariosJogosRepository.buscar();
    }

    public UsuariosJogosModel obterUsuariosJogosPorId(int id) {
        return usuariosJogosRepository.searchByCode(id);
    }

    public void criarUsuariosJogos(UsuariosJogosModel usuariosJogosModel) {
        usuariosJogosRepository.addUsuariosJogos(usuariosJogosModel);
    }

    public void excluirUsuariosJogos(int id) {
        usuariosJogosRepository.removeUsuariosJogos(id);
    }

    public void atualizarUsuariosJogos(int id, UsuariosJogosModel usuariosJogosModel) {
        usuariosJogosRepository.updateUsuariosJogos(id, usuariosJogosModel);
    }
}
