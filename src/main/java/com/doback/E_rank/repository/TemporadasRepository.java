package com.doback.E_rank.repository;

import com.doback.E_rank.entity.Temporadas;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TemporadasRepository {
    private List<Temporadas> temporadas = new ArrayList<>();


    public Temporadas buscarPorId(long code) {
        Temporadas temporada = temporadas
                .stream()
                .filter(p -> p.getIdTemporada() == code)
                .findFirst()
                .get();

        return temporada;
    }

    public List<Temporadas> buscar(){
        return temporadas;
    }

    public void adicionar(Temporadas temporada) {
        temporada.add(temporada);
    }

    public void remover(long code){
        temporadas.removeIf(p -> p.getIdTemporada() == code);
    }

    public void atualizar(Long id, Temporadas novaTemporada) {
        Temporadas temporadaExistente = buscarPorId(id);
        if (temporadaExistente != null) {
            temporadaExistente.setNome(novaTemporada.getNome());
            temporadaExistente.setDescricao(novaTemporada.getDescricao());
        }
    }
}
