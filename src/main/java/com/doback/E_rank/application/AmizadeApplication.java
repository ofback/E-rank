package com.doback.E_rank.application;

import com.doback.E_rank.entity.Amizade;
import com.doback.E_rank.facade.AmizadeFacade;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AmizadeApplication {

    private final AmizadeFacade amizadeFacade;

    public AmizadeApplication(AmizadeFacade amizadeFacade) {
        this.amizadeFacade = amizadeFacade;
    }

    public List<Amizade> obterTodasAmizades() {
        return amizadeFacade.listarAmizades();
    }

    public Optional<Amizade> obterAmizadePorId(Long id) {
        return amizadeFacade.buscarAmizadePorId(id);
    }

    public Amizade criarAmizade(Amizade amizade) {
        return amizadeFacade.salvarAmizade(amizade);
    }

    public void excluirAmizade(Long id) {
        amizadeFacade.excluirAmizade(id);
    }
}
