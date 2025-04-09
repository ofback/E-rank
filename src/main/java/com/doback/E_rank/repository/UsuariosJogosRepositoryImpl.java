package com.doback.E_rank.repository;

import com.doback.E_rank.entity.UsuariosJogos;
import com.doback.E_rank.interfaces.UsuariosJogosRepository;
import com.doback.E_rank.repository.jpa.UsuariosJogosJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class UsuariosJogosRepositoryImpl implements UsuariosJogosRepository {
    private final UsuariosJogosJpa usuariosJogosJpa;

    @Autowired
    public UsuariosJogosRepositoryImpl(UsuariosJogosJpa usuariosJogosJpa) {
        this.usuariosJogosJpa = usuariosJogosJpa;
    }

    @Override
    public UsuariosJogos searchByCode(int code) {
        return this.usuariosJogosJpa.findById(code).get();
    }

    @Override
    public List<UsuariosJogos> buscar() {
        return this.usuariosJogosJpa.findAll();
    }

    @Override
    public void addUsuariosJogos(UsuariosJogos usuariosJogos) {
        this.usuariosJogosJpa.save(usuariosJogos);
    }

    @Override
    public void removeUsuariosJogos(int code) {
        this.usuariosJogosJpa.deleteById(code);
    }

    @Override
    public void updateUsuariosJogos(int code, UsuariosJogos usuariosJogos) {
        UsuariosJogos usuariosJogosInDb = this.usuariosJogosJpa.findById(code).get();

        if (usuariosJogosInDb != null) {
            usuariosJogosInDb.setIdUsuarios(usuariosJogos.getIdUsuarios());
            usuariosJogos.setIdJogos(usuariosJogos.getIdJogos());

            this.usuariosJogosJpa.save(usuariosJogos);
        }
    }
    @Override
    public boolean estaVazio() {
        return this.usuariosJogosJpa.count() == 0;
    }
}
