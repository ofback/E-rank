package com.doback.E_rank.facade;

import com.doback.E_rank.application.AmizadesApplication;
import com.doback.E_rank.entity.Amizades;
import com.doback.E_rank.entity.Times;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AmizadesFacade {

    private final AmizadesApplication amizadeApplication;

    public AmizadesFacade(AmizadesApplication amizadeApplication) {
        this.amizadeApplication = amizadeApplication;
    }

    public List<Amizades> listarAmizades() {
        return amizadeApplication.obterTodasAmizades();
    }

    public Amizades buscarAmizadePorId(Long id) {
        return amizadeApplication.obterAmizadePorId(id);
    }

    public void salvarAmizade(Amizades amizade) {
        amizadeApplication.criarAmizade(amizade);
    }

    public void excluirAmizade(Long id) {
        amizadeApplication.excluirAmizade(id);
    }

    public void atualizarAmizades(Long id, Amizades amizades) {
        amizadeApplication.atualizarAmizades(id, amizades);
    }
}
