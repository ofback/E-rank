package com.doback.E_rank.application;

import com.doback.E_rank.entity.Usuario;
import com.doback.E_rank.facade.UsuarioFacade;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioApplication {

    private final UsuarioFacade usuarioFacade;

    public UsuarioApplication(UsuarioFacade usuarioFacade) {
        this.usuarioFacade = usuarioFacade;
    }

    public List<Usuario> obterTodosUsuarios() {
        return usuarioFacade.listarUsuarios();
    }

    public Optional<Usuario> obterUsuarioPorId(Long id) {
        return usuarioFacade.buscarUsuarioPorId(id);
    }

    public Usuario criarUsuario(Usuario usuario) {
        return usuarioFacade.salvarUsuario(usuario);
    }

    public void excluirUsuario(Long id) {
        usuarioFacade.excluirUsuario(id);
    }
}
