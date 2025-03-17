package com.doback.E_rank.repository;

import com.doback.E_rank.entity.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepository {
    private List<Usuario> usuarios = new ArrayList<>();

    public Usuario buscarPorId(long code) {
        Usuario usuario = usuarios
                .stream()
                .filter(p -> p.getIdUsuario() == code)
                .findFirst()
                .get();

        return usuario;
    }

    public List<Usuario> buscar(){
        return usuarios;
    }

    public void adicionar(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void remover(long code){
        usuarios.removeIf(p -> p.getIdUsuario() == code);
    }

    public void atualizar(long code, Usuario Usuario){
        Usuario usuarioInMemory = this.buscarPorId(code);

        usuarioInMemory.setStatus(Usuario.getStatus());
    }
}
