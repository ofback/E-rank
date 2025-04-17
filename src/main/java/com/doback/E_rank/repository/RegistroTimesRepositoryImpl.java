package com.doback.E_rank.repository;

import com.doback.E_rank.models.RegistroTimes;
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
    public RegistroTimes searchByCode(int code) {
        return this.registroTimesJpa.findById(code).get();
    }

    @Override
    public List<RegistroTimes> buscar() {
        return this.registroTimesJpa.findAll();
    }

    @Override
    public void addRegistroTimes(RegistroTimes registroTimes) {
        this.registroTimesJpa.save(registroTimes);
    }

    @Override
    public void removeRegistroTimes(int code) {
        this.registroTimesJpa.deleteById(code);
    }

    @Override
    public void updateRegistroTimes(int code, RegistroTimes registroTimes) {
        RegistroTimes registroTimesExistente = this.registroTimesJpa.findById(code).get();

        registroTimesExistente.setCargo(registroTimes.getCargo());

        this.registroTimesJpa.save(registroTimesExistente);
    }

    @Override
    public boolean estaVazio() {
        return false;
    }
}
