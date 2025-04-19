package com.doback.E_rank.application;


import com.doback.E_rank.models.UsuariosModel;
import com.doback.E_rank.interfaces.UsuariosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosApplication {
    private final UsuariosRepository usuarioRepository;

    public UsuariosApplication(UsuariosRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuariosModel> obterTodosUsuarios() {
        return usuarioRepository.buscar();
    }

    public UsuariosModel obterUsuarioPorId(long id) {
        return usuarioRepository.searchByCode(id);
    }

    public void criarUsuario(UsuariosModel usuario) {
        usuarioRepository.addUsuarios(usuario);
    }

    public void excluirUsuario(long id) {
        usuarioRepository.removeUsuarios(id);
    }

    public void atualizarUsuarios(int id, UsuariosModel usuariosModel) {
        usuarioRepository.updateUsuarios((long) id, usuariosModel);
    }
}
