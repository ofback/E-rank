package com.doback.E_rank.repository;

import com.doback.E_rank.entity.Estatisticas;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EstatisticasRepository {
    private List<Estatisticas> estatisticas = new ArrayList<>();

    public List<Estatisticas> buscarTodos() {
        return estatisticas;
    }

    public Estatisticas buscarPorId(Long id) {
        return estatisticas.stream()
                .filter(e -> e.getId_estatistica().equals(id))
                .findFirst()
                .orElse(null);
    }


    public void salvar(Estatisticas estatistica) {
        estatisticas.add(estatistica);
    }

    public void remover(Long id) {
        estatisticas.removeIf(e -> e.getId_estatistica().equals(id));
    }

    public void atualizar(Long id, Estatisticas novaEstatistica) {
        Estatisticas estatisticaExistente = buscarPorId(id);

        if (estatisticaExistente != null) {
            estatisticaExistente.setKills(novaEstatistica.getKills());
            estatisticaExistente.setAssistencias(novaEstatistica.getAssistencias());
            estatisticaExistente.setQts_partidas(novaEstatistica.getQts_partidas());
            estatisticaExistente.setSts_provacao(novaEstatistica.getSts_provacao());
            estatisticaExistente.setVitorias(novaEstatistica.getVitorias());
            estatisticaExistente.setDerrotas(novaEstatistica.getDerrotas());
            estatisticaExistente.setRecordKills(novaEstatistica.getRecordKills());
            estatisticaExistente.setHeadshots(novaEstatistica.getHeadshots());
        } else {
            System.out.println("Estatística com id " + id + " não encontrada.");
        }
    }
}
