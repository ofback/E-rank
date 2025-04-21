package com.doback.E_rank.application;
import com.doback.E_rank.entity.Jogos;
import com.doback.E_rank.models.JogosModel;
import com.doback.E_rank.interfaces.JogoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogosApplication {
    private final JogoRepository jogoRepository;

    public JogosApplication(JogoRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
    }

    public List<JogosModel> obterTodosJogos() {
        return jogoRepository.buscar();
    }

    public JogosModel obterJogoPorId(int id) {
        return jogoRepository.searchByCode(id);
    }

    public void criarJogo(JogosModel jogosModel) {
        Jogos jogosEntidade = new Jogos(
                jogosModel.getNome(),
                jogosModel.getDescricao(),
                jogosModel.getGenero()
        );
        if (jogosEntidade.validarJogo()) {
            jogoRepository.addJogos(jogosModel);
        } else {
            throw new IllegalArgumentException("Validação do jogo falhou: " + jogosEntidade.getErrosValidacao());
        }

    }

    public void excluirJogo(int id) {
        jogoRepository.removeJogos(id);
    }

    public void atualizarJogos(int id, JogosModel jogosModel) {
        Jogos jogosEntidade = new Jogos(
                jogosModel.getNome(),
                jogosModel.getDescricao(),
                jogosModel.getGenero()
        );
        if (jogosEntidade.validarJogo()) {
            jogoRepository.addJogos(jogosModel);
        } else {
            throw new IllegalArgumentException("Validação do jogo falhou: " + jogosEntidade.getErrosValidacao());
        }
    }
}
