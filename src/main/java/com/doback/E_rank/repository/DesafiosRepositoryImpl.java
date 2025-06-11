package com.doback.E_rank.repository;

import com.doback.E_rank.models.DesafiosModel;
import com.doback.E_rank.interfaces.DesafiosRepository;
import com.doback.E_rank.repository.jpa.DesafiosJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DesafiosRepositoryImpl implements DesafiosRepository {
    private final DesafiosJpa desafiosJpa;

    @Autowired
    public DesafiosRepositoryImpl(DesafiosJpa desafiosJpa) {
        this.desafiosJpa = desafiosJpa;
    }

    @Override
    public DesafiosModel searchByCode(int code) {
        return this.desafiosJpa.findById(code).get();
    }

    @Override
    public List<DesafiosModel> buscar() {
        return this.desafiosJpa.findAll();
    }

    @Override
    public void addDesafios(DesafiosModel desafiosModel) {
        this.desafiosJpa.save(desafiosModel);
    }

    @Override
    public void removeDesafios(int code) {
        this.desafiosJpa.deleteById(code);
    }

    @Override
    public void updateDesafios(int code, DesafiosModel desafiosModel) {
        DesafiosModel desafiosModelInDb = this.desafiosJpa.findById(code).get();

        desafiosModelInDb.setDataDesafio(desafiosModel.getDataDesafio());
        desafiosModelInDb.setResultado(desafiosModel.getResultado());
        desafiosModelInDb.setSts(desafiosModel.getSts());

        this.desafiosJpa.save(desafiosModelInDb);
    }

    @Override
    public boolean estaVazio() {
        return this.desafiosJpa.count() == 0;
    }
}
