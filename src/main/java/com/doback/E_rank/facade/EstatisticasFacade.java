package com.doback.E_rank.facade;

import com.doback.E_rank.application.EstatisticasApplication;
import com.doback.E_rank.entity.Estatisticas;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EstatisticasFacade {
    private final EstatisticasApplication estatisticaApplication;

    public EstatisticasFacade(EstatisticasApplication estatisticaApplication) {
        this.estatisticaApplication = estatisticaApplication;
    }

    public List<Estatisticas> listarEstatisticas() {
        return estatisticaApplication.obterTodas();
    }

    public Estatisticas buscarEstatisticaPorId(Long id) {
        return estatisticaApplication.obterPorId(id);
    }

    public void salvarEstatistica(Estatisticas estatistica) {
        estatisticaApplication.criar(estatistica);
    }

    public void excluirEstatistica(Long id) {
        estatisticaApplication.excluir(id);
    }

    public void atualizarEstatistica(Long id, Estatisticas estatistica) {
        estatisticaApplication.atualizar(id, estatistica);
    }
}