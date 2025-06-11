package com.doback.E_rank.infrastructure.repository;

import com.doback.E_rank.infrastructure.models.UsuariosModel;
import com.doback.E_rank.interfaces.UsuariosRepository;
import com.doback.E_rank.infrastructure.repository.jpa.UsuariosJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuariosRepositoryImpl implements UsuariosRepository {
    private final UsuariosJpa usuariosJpa;

    @Autowired
    public UsuariosRepositoryImpl(UsuariosJpa usuariosJpa) {
        this.usuariosJpa = usuariosJpa;
    }

    @Override
    public UsuariosModel searchByCode(Long id) {
        return this.usuariosJpa.findById(id).orElse(null);  // Modificado para Long
    }

    @Override
    public List<UsuariosModel> buscar() {
        return this.usuariosJpa.findAll();
    }

    @Override
    public void addUsuarios(UsuariosModel usuariosModel) {
        this.usuariosJpa.save(usuariosModel);
    }

    @Override
    public void removeUsuarios(Long id) {
        this.usuariosJpa.deleteById(id);  // Modificado para Long
    }

    @Override
    public void updateUsuarios(Long id, UsuariosModel usuariosModel) {
        UsuariosModel usuariosModelInDb = this.usuariosJpa.findById(id).orElse(null);
        if (usuariosModelInDb != null) {
            usuariosModelInDb.setSts(usuariosModel.getSts());
            usuariosModelInDb.setBiografia(usuariosModel.getBiografia());
            usuariosModelInDb.setNickname(usuariosModel.getNickname());
            usuariosModelInDb.setEmail(usuariosModel.getEmail());
            usuariosModelInDb.setSenha(usuariosModel.getSenha());
            usuariosModelInDb.setDataCriacao(usuariosModel.getDataCriacao());
            usuariosModelInDb.setNome(usuariosModel.getNome());

            this.usuariosJpa.save(usuariosModelInDb);
        }
    }

    @Override
    public boolean estaVazio() {
        return this.usuariosJpa.count() == 0;
    }

    @Override
    public Optional<UsuariosModel> findByEmail(String email) {
        return this.usuariosJpa.findByEmail(email);
    }
}
