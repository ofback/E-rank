package com.doback.E_rank.facade;
import com.doback.E_rank.application.JogosApplication;
import com.doback.E_rank.models.Jogos;
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

    public Jogos buscarJogoPorId(int id) {
        return jogoApplication.obterJogoPorId(id);
    }

    public void salvarJogo(Jogos jogo) {
        jogoApplication.criarJogo(jogo);
    }

    public void excluirJogo(int id) {
        jogoApplication.excluirJogo(id);
    }

    public void atualizarJogos(int id, Jogos jogos) {
        jogoApplication.atualizarJogos(id, jogos);
    }
}
