package com.doback.E_rank.repository;

import com.doback.E_rank.models.Usuarios;
import com.doback.E_rank.interfaces.UsuariosRepository;
import com.doback.E_rank.repository.jpa.UsuariosJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuariosRepositoryImpl implements UsuariosRepository {
    private final UsuariosJpa usuariosJpa;

    @Autowired
    public UsuariosRepositoryImpl(UsuariosJpa usuariosJpa) {
        this.usuariosJpa = usuariosJpa;
    }

    @Override
    public Usuarios searchByCode(Long id) {
        return this.usuariosJpa.findById(id).orElse(null);  // Modificado para Long
    }

    @Override
    public List<Usuarios> buscar() {
        return this.usuariosJpa.findAll();
    }

    @Override
    public void addUsuarios(Usuarios usuarios) {
        this.usuariosJpa.save(usuarios);
    }

    @Override
    public void removeUsuarios(Long id) {
        this.usuariosJpa.deleteById(id);  // Modificado para Long
    }

    @Override
    public void updateUsuarios(Long id, Usuarios usuarios) {
        Usuarios usuariosInDb = this.usuariosJpa.findById(id).orElse(null);
        if (usuariosInDb != null) {
            usuariosInDb.setSts(usuarios.getSts());
            usuariosInDb.setBiografia(usuarios.getBiografia());
            usuariosInDb.setNickname(usuarios.getNickname());
            usuariosInDb.setEmail(usuarios.getEmail());
            usuariosInDb.setSenha(usuarios.getSenha());
            usuariosInDb.setDataCriacao(usuarios.getDataCriacao());
            usuariosInDb.setNome(usuarios.getNome());

            this.usuariosJpa.save(usuariosInDb);
        }
    }

    @Override
    public boolean estaVazio() {
        return this.usuariosJpa.count() == 0;
    }
}
