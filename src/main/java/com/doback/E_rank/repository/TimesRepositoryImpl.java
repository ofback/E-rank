package com.doback.E_rank.repository;

import com.doback.E_rank.entity.Times;
import com.doback.E_rank.interfaces.TimesRepository;
import com.doback.E_rank.repository.jpa.TimesJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TimesRepositoryImpl implements TimesRepository {
    private final TimesJpa timesJpa;

    @Autowired
    public TimesRepositoryImpl(TimesJpa timesJpa) {
        this.timesJpa = timesJpa;
    }

    @Override
    public Times searchByCode(int code) {
        return this.timesJpa.findById(code).get();
    }

    @Override
    public List<Times> buscar() {
        return this.timesJpa.findAll();
    }

    @Override
    public void addTimes(Times times) {
        this.timesJpa.save(times);
    }


    @Override
    public void removeTimes(int code) {
        this.timesJpa.deleteById(code);
    }

    @Override
    public void updateTimes(int code, Times times) {
        Times timesExistentes = this.timesJpa.findById(code).get();

        timesExistentes.setNome(times.getNome());
        timesExistentes.setDescricao(times.getDescricao());

        this.timesJpa.save(timesExistentes);
    }

    @Override
    public boolean estaVazio() {
        return false;
    }
}
