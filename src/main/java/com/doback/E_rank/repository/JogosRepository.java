package com.doback.E_rank.repository;

import com.doback.E_rank.entity.Jogos;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JogosRepository {
    private List<Jogos> jogos = new ArrayList<>();

    public Jogos buscarPorId(long code) {
        Jogos jogo = jogos
                .stream()
                .filter(p -> p.getIdJogo() == code)
                .findFirst()
                .get();

        return jogo;
    }

    public List<Jogos> buscar(){
        return jogos;
    }

    public void adicionar(Jogos jogo) {
        jogos.add(jogo);
    }

    public void remover(long code){
        jogos.removeIf(p -> p.getIdJogo() == code);
    }

    public void atualizar(Long id, Jogos novoJogo) {
        Jogos jogoExistente = buscarPorId(id);
        if (jogoExistente != null) {
            jogoExistente.setNome(novoJogo.getNome());
            jogoExistente.setDescricao(novoJogo.getDescricao());
            jogoExistente.setGenero(novoJogo.getGenero());
        }
    }
}
