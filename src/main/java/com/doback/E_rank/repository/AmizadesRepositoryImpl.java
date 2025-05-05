package com.doback.E_rank.repository;

import com.doback.E_rank.models.AmizadesModel;
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
    public AmizadesModel searchByCode(int id) {
        return this.amizadesJpa.findById(id).get();
    }

    @Override
    public List<AmizadesModel> buscar() {
        return this.amizadesJpa.findAll();
    }

    @Override
    public void addAmizades(AmizadesModel amizadesModel) {
        this.amizadesJpa.save(amizadesModel);
    }

    @Override
    public void removeAmizades(int id) {
        this.amizadesJpa.deleteById(id);
    }

    @Override
    public void updateAmizades(int id, AmizadesModel amizadesModel) {
        AmizadesModel amizadeInDb = this.amizadesJpa.findById(id).orElse(null);

        if (amizadeInDb != null) {
            amizadeInDb.setStatus(amizadesModel.getStatus());
            amizadeInDb.setDataSolicitacao(amizadesModel.getDataSolicitacao());
            this.amizadesJpa.save(amizadeInDb);
        }
    }


    @Override
    public boolean estaVazio() {
        return this.amizadesJpa.count() == 0;
    }
}
