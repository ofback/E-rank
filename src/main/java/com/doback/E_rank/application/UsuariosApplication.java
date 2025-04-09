package com.doback.E_rank.application;


import com.doback.E_rank.entity.Amizades;
import com.doback.E_rank.entity.Usuarios;
import com.doback.E_rank.interfaces.UsuariosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosApplication {
    private final UsuariosRepository usuarioRepository;

    public UsuariosApplication(UsuariosRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuarios> obterTodosUsuarios() {
        return usuarioRepository.buscar();
    }

    public Usuarios obterUsuarioPorId(long id) {
        return usuarioRepository.searchByCode(id);
    }

    public void criarUsuario(Usuarios usuario) {
        usuarioRepository.addUsuarios(usuario);
    }

    public void excluirUsuario(long id) {
        usuarioRepository.removeUsuarios(id);
    }

    public void atualizarUsuarios(int id, Usuarios usuarios) {
        usuarioRepository.updateUsuarios((long) id, usuarios);
    }
}
