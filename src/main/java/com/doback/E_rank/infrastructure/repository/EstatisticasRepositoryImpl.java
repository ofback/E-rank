// E-rank/src/main/java/com/doback/E_rank/infrastructure/repository/EstatisticasRepositoryImpl.java
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
        // Uso de orElse(null) evita exceção imediata se não achar, ou pode usar orElseThrow
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
        // Chama o novo nome do método corrigido na JPA
        return estatisticasJpa.findByJogosModelIdAndStsProvacao(jogoId, 1);
    }

    @Override
    public List<EstatisticasModel> findAprovadasPorUsuario(int usuarioId) {
        // Chama o novo nome do método corrigido na JPA
        return estatisticasJpa.findByUsuariosModelIdAndStsProvacao(usuarioId, 1);
    }
}