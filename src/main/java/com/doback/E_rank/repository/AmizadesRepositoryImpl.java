package com.doback.E_rank.repository;

import com.doback.E_rank.entity.Amizades;
import com.doback.E_rank.interfaces.AmizadesRepository;
import com.doback.E_rank.repository.jpa.AmizadesJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AmizadesRepositoryImpl implements AmizadesRepository {
    private final AmizadesJpa amizadesJpa;

    @Autowired
    public AmizadesRepositoryImpl(AmizadesJpa amizadesJpa) {
        this.amizadesJpa = amizadesJpa;
    }


    @Override
    public Amizades searchByCode(int id) {
        return this.amizadesJpa.findById(id).get();
    }

    @Override
    public List<Amizades> buscar() {
        return this.amizadesJpa.findAll();
    }

    @Override
    public void addAmizades(Amizades amizades) {
        this.amizadesJpa.save(amizades);
    }

    @Override
    public void removeAmizades(int id) {
        this.amizadesJpa.deleteById(id);
    }

    @Override
    public void updateAmizades(int id, Amizades amizades) {
        Amizades amizadeInDb = this.amizadesJpa.findById(id).orElse(null);

        if (amizadeInDb != null) {
            amizadeInDb.setSts(amizades.getSts());
            amizadeInDb.setDataSolicitacao(amizades.getDataSolicitacao());
            this.amizadesJpa.save(amizadeInDb);
        }
    }


    @Override
    public boolean estaVazio() {
        return this.amizadesJpa.count() == 0;
    }
}
