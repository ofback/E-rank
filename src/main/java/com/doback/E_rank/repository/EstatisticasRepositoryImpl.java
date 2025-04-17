package com.doback.E_rank.repository;

import com.doback.E_rank.models.Estatisticas;
import com.doback.E_rank.interfaces.EstatisticasRepository;
import com.doback.E_rank.repository.jpa.EstatisticasJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EstatisticasRepositoryImpl implements EstatisticasRepository {

    private final EstatisticasJpa estatisticasJpa;

    @Autowired
    public EstatisticasRepositoryImpl(EstatisticasJpa estatisticasJpa) {
        this.estatisticasJpa = estatisticasJpa;
    }

    @Override
    public Estatisticas searchByCode(int id) {
        return this.estatisticasJpa.findById(id).get();

    }

    @Override
    public List<Estatisticas> buscar() {
        return this.estatisticasJpa.findAll();
    }

    @Override
    public void addEstatisticas(Estatisticas estatisticas) {
        this.estatisticasJpa.save(estatisticas);
    }

    @Override
    public void removeEstatisticas(int id) {
        this.estatisticasJpa.deleteById(id);
    }

    @Override
    public void updateEstatisticas(int id, Estatisticas novaEstatistica) {
        Estatisticas estatisticaInDb = this.estatisticasJpa.findById(id).get();

        estatisticaInDb.setKills(novaEstatistica.getKills());
        estatisticaInDb.setAssistencias(novaEstatistica.getAssistencias());
        estatisticaInDb.setQtsPartidas(novaEstatistica.getQtsPartidas());
        estatisticaInDb.setStsProvacao(novaEstatistica.getStsProvacao());
        estatisticaInDb.setVitorias(novaEstatistica.getVitorias());
        estatisticaInDb.setDerrotas(novaEstatistica.getDerrotas());
        estatisticaInDb.setRecordKills(novaEstatistica.getRecordKills());
        estatisticaInDb.setHeadshots(novaEstatistica.getHeadshots());

        this.estatisticasJpa.save(estatisticaInDb);
    }

    @Override
    public boolean estaVazio() {
        return this.estatisticasJpa.count() == 0;
    }
}
