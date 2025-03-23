package com.doback.E_rank.repository;

import com.doback.E_rank.entity.Usuarios;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UsuariosRepository {
    private final List<Usuarios> usuarios = new ArrayList<>();

    public Usuarios buscarPorId(long code) {
        return usuarios.stream()
                .filter(p -> p.getIdUsuario().equals(code))
                .findFirst()
                .orElse(null);
    }

    public List<Usuarios> buscar() {
        return usuarios;
    }

    public void adicionar(Usuarios usuario) {
        usuarios.add(usuario);
    }

    public void remover(long code) {
        usuarios.removeIf(p -> p.getIdUsuario().equals(code));
    }

    public void atualizar(long code, Usuarios usuarioAtualizado) {
        Usuarios usuarioInMemory = this.buscarPorId(code);

        if (usuarioInMemory != null) {
            usuarioInMemory.setSts(usuarioAtualizado.getSts());
            usuarioInMemory.setBiografia(usuarioAtualizado.getBiografia());
            usuarioInMemory.setNickname(usuarioAtualizado.getNickname());
            usuarioInMemory.setEmail(usuarioAtualizado.getEmail());
            usuarioInMemory.setSenha(usuarioAtualizado.getSenha());
            usuarioInMemory.setDataCriacao(usuarioAtualizado.getDataCriacao());
            usuarioInMemory.setNome(usuarioAtualizado.getNome());
        }
    }
}
