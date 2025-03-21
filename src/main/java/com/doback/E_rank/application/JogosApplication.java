package com.doback.E_rank.application;
import com.doback.E_rank.entity.Jogos;
import com.doback.E_rank.repository.JogosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogosApplication {
    private final JogosRepository jogoRepository;

    public JogosApplication(JogosRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
    }

    public List<Jogos> obterTodosJogos() {
        return jogoRepository.buscar();
    }

    public Jogos obterJogoPorId(long id) {
        return jogoRepository.buscarPorId(id);
    }

    public void criarJogo(Jogos jogo) {
        jogoRepository.adicionar(jogo);
    }

    public void excluirJogo(Long id) {
        jogoRepository.remover(id);
    }

    public void atualizarJogos(Long id, Jogos jogos) {
        jogoRepository.atualizar(id, jogos);
    }
}
