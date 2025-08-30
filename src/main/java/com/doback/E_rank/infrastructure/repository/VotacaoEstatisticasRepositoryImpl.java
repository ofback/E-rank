package com.doback.E_rank.infrastructure.repository;

import com.doback.E_rank.infrastructure.models.VotacaoEstatisticasModel;
import com.doback.E_rank.infrastructure.repository.jpa.VotacaoEstatisticasJpa;
import com.doback.E_rank.interfaces.VotacaoEstatisticasRepository;
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
        return this.votacaoEstatisticasJpa.findById(code).orElse(null);
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
        VotacaoEstatisticasModel votacaoEstatisticasModelInDb = this.votacaoEstatisticasJpa.findById(code).orElse(null);

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

    @Override

    public long countVotesForEstatistica(int idEstatistica){
        return votacaoEstatisticasJpa.countByIdEstatistica(idEstatistica);
    }
}

