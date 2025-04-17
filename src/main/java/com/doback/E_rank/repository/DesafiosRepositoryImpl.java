package com.doback.E_rank.repository;

import com.doback.E_rank.models.Desafios;
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
    public Desafios searchByCode(int code) {
        return this.desafiosJpa.findById(code).get();
    }

    @Override
    public List<Desafios> buscar() {
        return this.desafiosJpa.findAll();
    }

    @Override
    public void addDesafios(Desafios desafios) {
        this.desafiosJpa.save(desafios);
    }

    @Override
    public void removeDesafios(int code) {
        this.desafiosJpa.deleteById(code);
    }

    @Override
    public void updateDesafios(int code, Desafios desafios) {
        Desafios desafiosInDb = this.desafiosJpa.findById(code).get();

        desafiosInDb.setDataDesafio(desafios.getDataDesafio());
        desafiosInDb.setResultado(desafios.getResultado());
        desafiosInDb.setSts(desafios.getSts());

        this.desafiosJpa.save(desafiosInDb);
    }

    @Override
    public boolean estaVazio() {
        return false;
    }
}
