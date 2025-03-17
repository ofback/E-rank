package com.doback.E_rank.repository;

import com.doback.E_rank.entity.Amizade;
import com.doback.E_rank.entity.Temporada;
import io.micrometer.common.KeyValues;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TemporadaRepository {
    private List<Temporada> temporadas = new ArrayList<>();


    public Temporada buscarPorId(long code) {
        Temporada temporada = temporadas
                .stream()
                .filter(p -> p.getIdTemporada() == code)
                .findFirst()
                .get();

        return temporada;
    }

    public List<Temporada> buscar(){
        return temporadas;
    }

    public void adicionar(Temporada temporada) {
        temporada.add(temporada);
    }

    public void remover(long code){
        temporadas.removeIf(p -> p.getIdTemporada() == code);
    }

    public void atualizar(long code, Temporada temporada){
        Temporada TemporadaInMemory = this.buscarPorId(code);

        TemporadaInMemory.setStatus(temporada.getStatus());
    }
}
