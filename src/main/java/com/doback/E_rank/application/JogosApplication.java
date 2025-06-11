package com.doback.E_rank.application;
import com.doback.E_rank.entity.Jogos;
import com.doback.E_rank.infrastructure.models.JogosModel;
import com.doback.E_rank.interfaces.JogosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogosApplication {
    private final JogosRepository jogosRepository;

    public JogosApplication(JogosRepository jogosRepository) {
        this.jogosRepository = jogosRepository;
    }

    public List<JogosModel> obterTodosJogos() {
        return jogosRepository.buscar();
    }

    public JogosModel obterJogoPorId(int id) {
        return jogosRepository.searchByCode(id);
    }

    public void criarJogo(JogosModel jogosModel) {
        validar(jogosModel);
        jogosRepository.addJogos(jogosModel);
    }

    public void excluirJogo(int id) {
        jogosRepository.removeJogos(id);
    }

    public void atualizarJogos(int id, JogosModel jogosModel) {
        validar(jogosModel);
        jogosRepository.updateJogos(id, jogosModel);
    }

    private Jogos validar(JogosModel jogosModel){
        Jogos jogosEntidade = new Jogos(
                jogosModel.getNome(),
                jogosModel.getDescricao(),
                jogosModel.getGenero()
        );
        if (!jogosEntidade.validarJogo()) {
            throw new IllegalArgumentException("Validação do jogo falhou: " + jogosEntidade.getErrosValidacao());
        }
        return jogosEntidade;
    }
}
