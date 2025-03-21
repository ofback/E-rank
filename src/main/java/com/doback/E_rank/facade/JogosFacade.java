package com.doback.E_rank.facade;
import com.doback.E_rank.application.JogosApplication;
import com.doback.E_rank.entity.Jogos;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JogosFacade {
    private final JogosApplication jogoApplication;

    public JogosFacade(JogosApplication jogoApplication) {
        this.jogoApplication = jogoApplication;
    }

    public List<Jogos> listarJogos() {
        return jogoApplication.obterTodosJogos();
    }

    public Jogos buscarJogoPorId(Long id) {
        return jogoApplication.obterJogoPorId(id);
    }

    public void salvarJogo(Jogos jogo) {
        jogoApplication.criarJogo(jogo);
    }

    public void excluirJogo(Long id) {
        jogoApplication.excluirJogo(id);
    }

    public void atualizarJogos(Long id, Jogos jogos) {
        jogoApplication.atualizarJogos(id, jogos);
    }
}
