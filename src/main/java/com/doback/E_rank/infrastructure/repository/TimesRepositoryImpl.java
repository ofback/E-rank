package com.doback.E_rank.infrastructure.repository;

import com.doback.E_rank.infrastructure.models.TimesModel;
import com.doback.E_rank.interfaces.TimesRepository;
import com.doback.E_rank.infrastructure.repository.jpa.TimesJpa;
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
    public TimesModel searchByCode(int code) {
        return this.timesJpa.findById(code).orElse(null);
    }

    @Override
    public List<TimesModel> buscar() {
        return this.timesJpa.findAll();
    }

    @Override
    public void addTimes(TimesModel timesModel) {
        this.timesJpa.save(timesModel);
    }


    @Override
    public void removeTimes(int code) {
        this.timesJpa.deleteById(code);
    }

    @Override
    public void updateTimes(int code, TimesModel timesModel) {
        TimesModel timesModelExistentes = this.timesJpa.findById(code).orElse(null);

        timesModelExistentes.setNome(timesModel.getNome());
        timesModelExistentes.setDescricao(timesModel.getDescricao());

        this.timesJpa.save(timesModelExistentes);
    }

    @Override
    public boolean estaVazio() {
        return this.timesJpa.count() == 0;
    }
}
