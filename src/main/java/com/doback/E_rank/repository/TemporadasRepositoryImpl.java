package com.doback.E_rank.repository;

import com.doback.E_rank.models.Temporadas;
import com.doback.E_rank.interfaces.TemporadasRepository;
import com.doback.E_rank.repository.jpa.TemporadasJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TemporadasRepositoryImpl implements TemporadasRepository {
    private final TemporadasJpa temporadasJpa;

    @Autowired
    public TemporadasRepositoryImpl(TemporadasJpa temporadasJpa) {
        this.temporadasJpa = temporadasJpa;
    }

    @Override
    public Temporadas searchByCode(int code) {
        return this.temporadasJpa.findById(code).orElse(null);
    }

    @Override
    public List<Temporadas> buscar() {
        return this.temporadasJpa.findAll();
    }

    @Override
    public void addTemporadas(Temporadas temporadas) {
        this.temporadasJpa.save(temporadas);
    }

    @Override
    public void removeTemporadas(int code) {
        this.temporadasJpa.deleteById(code);
    }

    @Override
    public void updateTemporadas(int code, Temporadas temporadas) {
        Temporadas temporadaInDb = this.temporadasJpa.findById(code).orElse(null);
        if (temporadaInDb != null) {
            temporadaInDb.setData_inicio(temporadas.getData_inicio());
            temporadaInDb.setData_fim(temporadas.getData_fim());



            this.temporadasJpa.save(temporadaInDb);
        }
    }

    @Override
    public boolean estaVazio() {
        return this.temporadasJpa.count() == 0;
    }
}
