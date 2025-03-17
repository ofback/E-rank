package com.doback.E_rank.facade;

import com.doback.E_rank.application.JogoApplication;
import com.doback.E_rank.entity.Jogo;
import com.doback.E_rank.repository.JogoRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JogoFacade {
    private final JogoApplication jogoApplication;

    public JogoFacade(JogoApplication jogoApplication) {
        this.jogoApplication = jogoApplication;
    }

    public List<Jogo> listarJogos() {
        return jogoApplication.obterTodosJogos();
    }

    public Jogo buscarJogoPorId(Long id) {
        return jogoApplication.obterJogoPorId(id);
    }

    public void salvarJogo(Jogo jogo) {
        jogoApplication.criarJogo(jogo);
    }

    public void excluirJogo(Long id) {
        jogoApplication.excluirJogo(id);
    }
}
