package com.doback.E_rank.repository;

import com.doback.E_rank.models.RegistroTimesModel;
import com.doback.E_rank.interfaces.RegistroTimesRepository;
import com.doback.E_rank.repository.jpa.RegistroTimesJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RegistroTimesRepositoryImpl implements RegistroTimesRepository {
    private final RegistroTimesJpa registroTimesJpa;

    @Autowired
    public RegistroTimesRepositoryImpl(RegistroTimesJpa registroTimesJpa) {
        this.registroTimesJpa = registroTimesJpa;
    }

    @Override
    public RegistroTimesModel searchByCode(int code) {
        return this.registroTimesJpa.findById(code).get();
    }

    @Override
    public List<RegistroTimesModel> buscar() {
        return this.registroTimesJpa.findAll();
    }

    @Override
    public void addRegistroTimes(RegistroTimesModel registroTimesModel) {
        this.registroTimesJpa.save(registroTimesModel);
    }

    @Override
    public void removeRegistroTimes(int code) {
        this.registroTimesJpa.deleteById(code);
    }

    @Override
    public void updateRegistroTimes(int code, RegistroTimesModel registroTimesModel) {
        RegistroTimesModel registroTimesModelExistente = this.registroTimesJpa.findById(code).get();

        registroTimesModelExistente.setCargo(registroTimesModel.getCargo());

        this.registroTimesJpa.save(registroTimesModelExistente);
    }

    @Override
    public boolean estaVazio() {
        return false;
    }
}
