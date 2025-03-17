package com.doback.E_rank.facade;

import com.doback.E_rank.application.UsuarioApplication;
import com.doback.E_rank.entity.Usuario;
import com.doback.E_rank.repository.UsuarioRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioFacade {
    private final UsuarioApplication usuarioApplication;

    public UsuarioFacade(UsuarioApplication usuarioApplication) {
        this.usuarioApplication = usuarioApplication;
    }

    public List<Usuario> listarUsuarios() {
        return usuarioApplication.obterTodosUsuarios();
    }

    public Usuario buscarUsuarioPorId(Long id) {
        return usuarioApplication.obterUsuarioPorId(id);
    }

    public void salvarUsuario(Usuario usuario) {
        usuarioApplication.criarUsuario(usuario);
    }

    public void excluirUsuario(Long id) {
        usuarioApplication.excluirUsuario(id);
    }
}
