package com.doback.E_rank.infrastructure.repository;

import com.doback.E_rank.infrastructure.models.EstatisticasModel;
import com.doback.E_rank.interfaces.EstatisticasRepository;
import com.doback.E_rank.infrastructure.repository.jpa.EstatisticasJpa;
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
    public EstatisticasModel searchByCode(int id) {
        // .get() lança exceção se não achar. .orElse(null) é mais seguro se preferir tratar null depois.
        return this.estatisticasJpa.findById(id).orElse(null);
    }

    @Override
    public List<EstatisticasModel> buscar() {
        return this.estatisticasJpa.findAll();
    }

    @Override
    public void addEstatisticas(EstatisticasModel estatisticasModel) {
        this.estatisticasJpa.save(estatisticasModel);
    }

    @Override
    public void removeEstatisticas(int id) {
        this.estatisticasJpa.deleteById(id);
    }

    @Override
    public void updateEstatisticas(int id, EstatisticasModel novaEstatistica) {
        EstatisticasModel estatisticaInDb = this.estatisticasJpa.findById(id).orElse(null);

        if (estatisticaInDb != null) {
            estatisticaInDb.setKills(novaEstatistica.getKills());
            estatisticaInDb.setAssistencias(novaEstatistica.getAssistencias());
            estatisticaInDb.setQtdPartidas(novaEstatistica.getQtdPartidas());
            estatisticaInDb.setStsProvacao(novaEstatistica.getStsProvacao());
            estatisticaInDb.setVitorias(novaEstatistica.getVitorias());
            estatisticaInDb.setDerrotas(novaEstatistica.getDerrotas());
            estatisticaInDb.setRecordKills(novaEstatistica.getRecordKills());
            estatisticaInDb.setHeadshots(novaEstatistica.getHeadshots());

            this.estatisticasJpa.save(estatisticaInDb);
        }
    }

    @Override
    public boolean estaVazio() {
        return this.estatisticasJpa.count() == 0;
    }

    @Override
    public List<EstatisticasModel> findAprovadasPorJogo(int jogoId) {
        // CHAMADA CORRIGIDA
        return estatisticasJpa.findByJogosModelIdAndStsProvacao(jogoId, 1); // 1 = Aprovado
    }

    @Override
    public List<EstatisticasModel> findAprovadasPorUsuario(int usuarioId) {
        // CHAMADA CORRIGIDA
        return estatisticasJpa.findByUsuariosModelIdAndStsProvacao(usuarioId, 1); // 1 = Aprovado
    }
}