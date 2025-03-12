package com.doback.E_rank.facade;

import com.doback.E_rank.application.AmizadeApplication;
import com.doback.E_rank.entity.Amizade;
import com.doback.E_rank.repository.AmizadeRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AmizadeFacade {

    private final AmizadeApplication amizadeApplication;

    public AmizadeFacade(AmizadeApplication amizadeApplication) {
        this.amizadeApplication = amizadeApplication;
    }

    public List<Amizade> listarAmizades() {
        return amizadeApplication.obterTodasAmizades();
    }

    public Amizade buscarAmizadePorId(Long id) {
        return amizadeApplication.obterAmizadePorId(id);
    }

    public void salvarAmizade(Amizade amizade) {
        amizadeApplication.criarAmizade(amizade);
    }

    public void excluirAmizade(Long id) {
        amizadeApplication.excluirAmizade(id);
    }
}
