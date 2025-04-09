package com.doback.E_rank.repository;

import com.doback.E_rank.entity.VotacaoEstatisticas;
import com.doback.E_rank.interfaces.VotacaoEstatisticasRepository;
import com.doback.E_rank.repository.jpa.VotacaoEstatisticasJpa;
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
    public VotacaoEstatisticas searchByCode(int code) {
        return this.votacaoEstatisticasJpa.findById(code).get();
    }

    @Override
    public List<VotacaoEstatisticas> buscar() {
        return this.votacaoEstatisticasJpa.findAll();
    }

    @Override
    public void addVotacaoEstatisticas(VotacaoEstatisticas votacaoEstatisticas) {
        this.votacaoEstatisticasJpa.save(votacaoEstatisticas);
    }

    @Override
    public void removeVotacaoEstatisticas(int code) {
        this.votacaoEstatisticasJpa.deleteById(code);
    }

    @Override
    public void updateVotacaoEstatisticas(int code, VotacaoEstatisticas votacaoEstatisticas) {
        VotacaoEstatisticas votacaoEstatisticasInDb = this.votacaoEstatisticasJpa.findById(code).get();

        if (votacaoEstatisticasInDb != null) {
            votacaoEstatisticasInDb.setData_voto(votacaoEstatisticas.getData_voto());
            votacaoEstatisticasInDb.setVoto(votacaoEstatisticas.isVoto());

            this.votacaoEstatisticasJpa.save(votacaoEstatisticasInDb);
        }
    }

    @Override
    public boolean estaVazio() {
        return this.votacaoEstatisticasJpa.count() == 0;
    }
}
