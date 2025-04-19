package com.doback.E_rank.facade;

import com.doback.E_rank.application.EstatisticasApplication;
import com.doback.E_rank.models.EstatisticasModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EstatisticasFacade {
    private final EstatisticasApplication estatisticaApplication;

    public EstatisticasFacade(EstatisticasApplication estatisticaApplication) {
        this.estatisticaApplication = estatisticaApplication;
    }

    public List<EstatisticasModel> listarEstatisticas() {
        return estatisticaApplication.obterTodas();
    }

    public EstatisticasModel buscarEstatisticaPorId(int id) {
        return estatisticaApplication.obterPorId(id);
    }

    public void salvarEstatistica(EstatisticasModel estatistica) {
        estatisticaApplication.criar(estatistica);
    }

    public void excluirEstatistica(int id) {
        estatisticaApplication.excluir(id);
    }

    public void atualizarEstatistica(int id, EstatisticasModel estatistica) {
        estatisticaApplication.atualizar(id, estatistica);
    }
}