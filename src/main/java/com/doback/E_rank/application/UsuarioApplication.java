package com.doback.E_rank.application;


import com.doback.E_rank.entity.Usuario;
import com.doback.E_rank.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioApplication {
    private final UsuarioRepository usuarioRepository;

    public UsuarioApplication(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> obterTodosUsuarios() {
        return usuarioRepository.buscar();
    }

    public Usuario obterUsuarioPorId(long id) {
        return usuarioRepository.buscarPorId(id);
    }

    public void criarUsuario(Usuario usuario) {
        usuarioRepository.adicionar(usuario);
    }

    public void excluirUsuario(Long id) {
        usuarioRepository.remover(id);
    }
}
