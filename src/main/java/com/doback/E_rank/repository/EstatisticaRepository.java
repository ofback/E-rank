package com.doback.E_rank.repository;

import com.doback.E_rank.entity.Estatistica;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EstatisticaRepository {
    private List<Estatistica> estatisticas = new ArrayList<>();

    public List<Estatistica> buscarTodos() {
        return estatisticas;
    }

    public Estatistica buscarPorId(Long id) {
        return estatisticas.stream().filter(e -> e.getId_estatistica().equals(id)).findFirst().orElse(null);
    }

    public void salvar(Estatistica estatistica) {
        estatisticas.add(estatistica);
    }

    public void remover(Long id) {
        estatisticas.removeIf(e -> e.getId_estatistica().equals(id));
    }
    public void atualizar(Long id, Estatistica novaEstatistica) {
        Estatistica estatisticaExistente = buscarPorId(id);
        if (estatisticaExistente != null) {
            estatisticaExistente.setAssistencias(novaEstatistica.getAssistencias());
            estatisticaExistente.setQts_partidas(novaEstatistica.getQts_partidas());
            estatisticaExistente.setSts_provacao(novaEstatistica.getSts_provacao());
        }
    }
}
