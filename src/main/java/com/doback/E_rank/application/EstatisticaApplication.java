package com.doback.E_rank.application;

import com.doback.E_rank.entity.Estatistica;
import com.doback.E_rank.facade.EstatisticaFacade;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstatisticaApplication {

    private final EstatisticaFacade estatisticaFacade;

    public EstatisticaApplication(EstatisticaFacade estatisticaFacade) {
        this.estatisticaFacade = estatisticaFacade;
    }

    public List<Estatistica> obterTodasEstatisticas() {
        return estatisticaFacade.listarEstatisticas();
    }

    public Optional<Estatistica> obterEstatisticaPorId(Long id) {
        return estatisticaFacade.buscarEstatisticaPorId(id);
    }

    public Estatistica criarEstatistica(Estatistica estatistica) {
        return estatisticaFacade.salvarEstatistica(estatistica);
    }

    public void excluirEstatistica(Long id) {
        estatisticaFacade.excluirEstatistica(id);
    }
}
