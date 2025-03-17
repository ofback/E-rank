package com.doback.E_rank.application;

import com.doback.E_rank.entity.Jogo;
import com.doback.E_rank.repository.JogoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogoApplication {
    private final JogoRepository jogoRepository;

    public JogoApplication(JogoRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
    }

    public List<Jogo> obterTodosJogos() {
        return jogoRepository.buscar();
    }

    public Jogo obterJogoPorId(long id) {
        return jogoRepository.buscarPorId(id);
    }

    public void criarJogo(Jogo jogo) {
        jogoRepository.adicionar(jogo);
    }

    public void excluirJogo(Long id) {
        jogoRepository.remover(id);
    }
}
