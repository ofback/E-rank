package com.doback.E_rank.facade;

import com.doback.E_rank.application.AmizadesApplication;
import com.doback.E_rank.models.AmizadesModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AmizadesFacade {

    private final AmizadesApplication amizadeApplication;

    public AmizadesFacade(AmizadesApplication amizadeApplication) {
        this.amizadeApplication = amizadeApplication;
    }

    public List<AmizadesModel> listarAmizades() {
        return amizadeApplication.obterTodasAmizades();
    }

    public AmizadesModel buscarAmizadePorId(int id) {
        return amizadeApplication.obterAmizadePorId(id);
    }

    public void salvarAmizade(AmizadesModel amizade) {
        amizadeApplication.criarAmizade(amizade);
    }

    public void excluirAmizade(int id) {
        amizadeApplication.excluirAmizade(id);
    }

    public void atualizarAmizades(int id, AmizadesModel amizadesModel) {
        amizadeApplication.atualizarAmizades(id, amizadesModel);
    }
}
