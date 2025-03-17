package com.doback.E_rank.facade;

import com.doback.E_rank.application.EstatisticaApplication;
import com.doback.E_rank.entity.Estatistica;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EstatisticaFacade {
    private final EstatisticaApplication estatisticaApplication;

    public EstatisticaFacade(EstatisticaApplication estatisticaApplication) {
        this.estatisticaApplication = estatisticaApplication;
    }

    public List<Estatistica> listarEstatisticas() {
        return estatisticaApplication.obterTodas();
    }

    public Estatistica buscarEstatisticaPorId(Long id) {
        return estatisticaApplication.obterPorId(id);
    }

    public void salvarEstatistica(Estatistica estatistica) {
        estatisticaApplication.criar(estatistica);
    }

    public void excluirEstatistica(Long id) {
        estatisticaApplication.excluir(id);
    }

    public void atualizarEstatistica(Long id, Estatistica estatistica) {
        estatisticaApplication.atualizar(id, estatistica);
    }
}