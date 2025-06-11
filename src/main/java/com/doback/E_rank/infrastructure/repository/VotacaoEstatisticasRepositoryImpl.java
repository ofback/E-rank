package com.doback.E_rank.infrastructure.repository;

import com.doback.E_rank.infrastructure.models.VotacaoEstatisticasModel;
import com.doback.E_rank.interfaces.VotacaoEstatisticasRepository;
import com.doback.E_rank.infrastructure.repository.jpa.VotacaoEstatisticasJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VotacaoEstatisticasRepositoryImpl implements VotacaoEstatisticasRepository {
    private final VotacaoEstatisticasJpa votacaoEstatisticasJpa;

    @Autowired
    public VotacaoEstatisticasRepositoryImpl(VotacaoEstatisticasJpa votacaoEstatisticasJpa) {
        this.votacaoEstatisticasJpa = votacaoEstatisticasJpa;
    }

    @Override
    public VotacaoEstatisticasModel searchByCode(int code) {
        return this.votacaoEstatisticasJpa.findById(code).get();
    }

    @Override
    public List<VotacaoEstatisticasModel> buscar() {
        return this.votacaoEstatisticasJpa.findAll();
    }

    @Override
    public void addVotacaoEstatisticas(VotacaoEstatisticasModel votacaoEstatisticasModel) {
        this.votacaoEstatisticasJpa.save(votacaoEstatisticasModel);
    }

    @Override
    public void removeVotacaoEstatisticas(int code) {
        this.votacaoEstatisticasJpa.deleteById(code);
    }

    @Override
    public void updateVotacaoEstatisticas(int code, VotacaoEstatisticasModel votacaoEstatisticasModel) {
        VotacaoEstatisticasModel votacaoEstatisticasModelInDb = this.votacaoEstatisticasJpa.findById(code).get();

        if (votacaoEstatisticasModelInDb != null) {
            votacaoEstatisticasModelInDb.setData_voto(votacaoEstatisticasModel.getData_voto());
            votacaoEstatisticasModelInDb.setVoto(votacaoEstatisticasModel.isVoto());

            this.votacaoEstatisticasJpa.save(votacaoEstatisticasModelInDb);
        }
    }

    @Override
    public boolean estaVazio() {
        return this.votacaoEstatisticasJpa.count() == 0;
    }
}
