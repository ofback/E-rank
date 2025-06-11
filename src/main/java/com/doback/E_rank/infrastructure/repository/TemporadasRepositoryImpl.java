package com.doback.E_rank.infrastructure.repository;

import com.doback.E_rank.infrastructure.models.TemporadasModel;
import com.doback.E_rank.interfaces.TemporadasRepository;
import com.doback.E_rank.infrastructure.repository.jpa.TemporadasJpa;
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
    public TemporadasModel searchByCode(int code) {
        return this.temporadasJpa.findById(code).orElse(null);
    }

    @Override
    public List<TemporadasModel> buscar() {
        return this.temporadasJpa.findAll();
    }

    @Override
    public void addTemporadas(TemporadasModel temporadasModel) {
        this.temporadasJpa.save(temporadasModel);
    }

    @Override
    public void removeTemporadas(int code) {
        this.temporadasJpa.deleteById(code);
    }

    @Override
    public void updateTemporadas(int code, TemporadasModel temporadasModel) {
        TemporadasModel temporadaInDb = this.temporadasJpa.findById(code).orElse(null);
        if (temporadaInDb != null) {
            temporadaInDb.setNome(temporadasModel.getNome());
            temporadaInDb.setDescricao(temporadasModel.getDescricao());
            temporadaInDb.setData_inicio(temporadasModel.getData_inicio());
            temporadaInDb.setData_fim(temporadasModel.getData_fim());

            this.temporadasJpa.save(temporadaInDb);
        }
    }

    @Override
    public boolean estaVazio() {
        return this.temporadasJpa.count() == 0;
    }
}

