package com.doback.E_rank.application;

import com.doback.E_rank.entity.Jogo;
import com.doback.E_rank.facade.JogoFacade;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogoApplication {

    private final JogoFacade jogoFacade;

    public JogoApplication(JogoFacade jogoFacade) {
        this.jogoFacade = jogoFacade;
    }

    public List<Jogo> obterTodosJogos() {
        return jogoFacade.listarJogos();
    }

    public Optional<Jogo> obterJogoPorId(Long id) {
        return jogoFacade.buscarJogoPorId(id);
    }

    public Jogo criarJogo(Jogo jogo) {
        return jogoFacade.salvarJogo(jogo);
    }

    public void excluirJogo(Long id) {
        jogoFacade.excluirJogo(id);
    }
}
