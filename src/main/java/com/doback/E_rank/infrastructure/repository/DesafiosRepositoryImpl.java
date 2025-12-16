package com.doback.E_rank.infrastructure.repository;

import com.doback.E_rank.infrastructure.models.DesafiosModel;
import com.doback.E_rank.interfaces.DesafiosRepository;
import com.doback.E_rank.infrastructure.repository.jpa.DesafiosJpa;
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
        return this.desafiosJpa.findById(code).orElse(null);
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
        DesafiosModel desafiosModelInDb = this.desafiosJpa.findById(code)
                .orElseThrow(() -> new RuntimeException("Desafio não encontrado para atualização"));
        desafiosModelInDb.setDataHora(desafiosModel.getDataHora());
        desafiosModelInDb.setResultado(desafiosModel.getResultado());
        desafiosModelInDb.setStatus(desafiosModel.getStatus());

        this.desafiosJpa.save(desafiosModelInDb);
    }

    @Override
    public boolean estaVazio() {
        return this.desafiosJpa.count() == 0;
    }
}