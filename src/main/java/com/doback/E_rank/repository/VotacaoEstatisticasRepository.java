package com.doback.E_rank.repository;

import com.doback.E_rank.entity.VotacaoEstatisticas;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository

public class VotacaoEstatisticasRepository {
    private List<VotacaoEstatisticas> votacaoEstatisticas = new ArrayList<>();

    public VotacaoEstatisticas buscarPorId(long code) {
        VotacaoEstatisticas votacaoEstatistica = votacaoEstatisticas
                .stream()
                .filter(p -> p.getId_votacao_estatistica() == code)
                .findFirst()
                .get();

        return votacaoEstatistica;
    }

    public List<VotacaoEstatisticas> buscar(){
        return votacaoEstatisticas;
    }

    public void adicionar(VotacaoEstatisticas votacaoEstatistica) {
        votacaoEstatisticas.add(votacaoEstatistica);
    }

    public void remover(long code){
        votacaoEstatisticas.removeIf(p -> p.getId_votacao_estatistica() == code);
    }

    public void atualizar(Long id, VotacaoEstatisticas novoVotacaoEstatisticas) {
        VotacaoEstatisticas VotacaoEstatisticasExistente = buscarPorId(id);
        if (VotacaoEstatisticasExistente != null) {
            VotacaoEstatisticasExistente.setVoto(novoVotacaoEstatisticas.isVoto());
        }
    }
}
