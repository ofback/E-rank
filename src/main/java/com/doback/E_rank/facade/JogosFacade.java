package com.doback.E_rank.facade;
import com.doback.E_rank.application.JogosApplication;
import com.doback.E_rank.models.JogosModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JogosFacade {
    private final JogosApplication jogoApplication;

    public JogosFacade(JogosApplication jogoApplication) {
        this.jogoApplication = jogoApplication;
    }

    public List<JogosModel> listarJogos() {
        return jogoApplication.obterTodosJogos();
    }

    public JogosModel buscarJogoPorId(int id) {
        return jogoApplication.obterJogoPorId(id);
    }

    public void salvarJogo(JogosModel jogo) {
        jogoApplication.criarJogo(jogo);
    }

    public void excluirJogo(int id) {
        jogoApplication.excluirJogo(id);
    }

    public void atualizarJogos(int id, JogosModel jogosModel) {
        jogoApplication.atualizarJogos(id, jogosModel);
    }
}
