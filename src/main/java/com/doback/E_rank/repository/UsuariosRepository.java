package com.doback.E_rank.repository;

import com.doback.E_rank.entity.Usuarios;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuariosRepository {
    private List<Usuarios> usuarios = new ArrayList<>();

    public Usuarios buscarPorId(long code) {
        Usuarios usuario = usuarios
                .stream()
                .filter(p -> p.getIdUsuario() == code)
                .findFirst()
                .get();

        return usuario;
    }

    public List<Usuarios> buscar(){
        return usuarios;
    }

    public void adicionar(Usuarios usuario) {
        usuarios.add(usuario);
    }

    public void remover(long code){
        usuarios.removeIf(p -> p.getIdUsuario() == code);
    }

    public void atualizar(long code, Usuarios Usuario){
        Usuarios usuarioInMemory = this.buscarPorId(code);

        usuarioInMemory.setStatus(Usuario.getStatus());
    }
}
