package com.doback.E_rank.repository;

import com.doback.E_rank.entity.Estatistica;
import com.doback.E_rank.entity.Jogo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JogoRepository {
    private List<Jogo> jogos = new ArrayList<>();

    public Jogo buscarPorId(long code) {
        Jogo jogo = jogos
                .stream()
                .filter(p -> p.getIdJogo() == code)
                .findFirst()
                .get();

        return jogo;
    }

    public List<Jogo> buscar(){
        return jogos;
    }

    public void adicionar(Jogo jogo) {
        jogos.add(jogo);
    }

    public void remover(long code){
        jogos.removeIf(p -> p.getIdJogo() == code);
    }

    public void atualizar(Long id, Jogo novoJogo) {
        Jogo jogoExistente = buscarPorId(id);
        if (jogoExistente != null) {
            jogoExistente.setNome(novoJogo.getNome());
            jogoExistente.setDescricao(novoJogo.getDescricao());
            jogoExistente.setGenero(novoJogo.getGenero());
        }
    }
}
