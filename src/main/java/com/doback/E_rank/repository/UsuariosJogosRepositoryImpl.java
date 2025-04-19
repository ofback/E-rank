package com.doback.E_rank.repository;

import com.doback.E_rank.models.UsuariosJogosModel;
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
    public UsuariosJogosModel searchByCode(int code) {
        return this.usuariosJogosJpa.findById(code).get();
    }

    @Override
    public List<UsuariosJogosModel> buscar() {
        return this.usuariosJogosJpa.findAll();
    }

    @Override
    public void addUsuariosJogos(UsuariosJogosModel usuariosJogosModel) {
        this.usuariosJogosJpa.save(usuariosJogosModel);
    }

    @Override
    public void removeUsuariosJogos(int code) {
        this.usuariosJogosJpa.deleteById(code);
    }

    @Override
    public void updateUsuariosJogos(int code, UsuariosJogosModel usuariosJogosModel) {
        UsuariosJogosModel usuariosJogosModelInDb = this.usuariosJogosJpa.findById(code).get();

        if (usuariosJogosModelInDb != null) {
            usuariosJogosModelInDb.setIdUsuarios(usuariosJogosModel.getIdUsuarios());
            usuariosJogosModel.setIdJogos(usuariosJogosModel.getIdJogos());

            this.usuariosJogosJpa.save(usuariosJogosModel);
        }
    }
    @Override
    public boolean estaVazio() {
        return this.usuariosJogosJpa.count() == 0;
    }
}
