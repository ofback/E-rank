package com.doback.E_rank.application;
import com.doback.E_rank.entity.Jogos;
import com.doback.E_rank.interfaces.JogoRepository;
import com.doback.E_rank.repository.JogosRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogosApplication {
    private final JogoRepository jogoRepository;

    public JogosApplication(JogoRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
    }

    public List<Jogos> obterTodosJogos() {
        return jogoRepository.buscar();
    }

    public Jogos obterJogoPorId(int id) {
        return jogoRepository.searchByCode(id);
    }

    public void criarJogo(Jogos jogo) {
        jogoRepository.addJogos(jogo);
    }

    public void excluirJogo(int id) {
        jogoRepository.removeJogos(id);
    }

    public void atualizarJogos(int id, Jogos jogos) {
        jogoRepository.updateJogos(id, jogos);
    }
}
