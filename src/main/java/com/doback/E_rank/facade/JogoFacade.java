package com.doback.E_rank.facade;

import com.doback.E_rank.entity.Jogo;
import com.doback.E_rank.repository.JogoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JogoFacade {

    private final JogoRepository jogoRepository;

    public JogoFacade(JogoRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
    }

    public List<Jogo> listarJogos() {
        return jogoRepository.findAll();
    }

    public Optional<Jogo> buscarJogoPorId(Long id) {
        return jogoRepository.findById(id);
    }

    public Jogo salvarJogo(Jogo jogo) {
        return jogoRepository.save(jogo);
    }

    public void excluirJogo(Long id) {
        jogoRepository.deleteById(id);
    }
}
