package com.doback.E_rank.application;


import com.doback.E_rank.entity.Usuarios;
import com.doback.E_rank.repository.UsuariosRepository;
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
        return usuarioRepository.buscarPorId(id);
    }

    public void criarUsuario(Usuarios usuario) {
        usuarioRepository.adicionar(usuario);
    }

    public void excluirUsuario(Long id) {
        usuarioRepository.remover(id);
    }
}
