package com.doback.E_rank.repository;

import com.doback.E_rank.entity.Temporadas;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TemporadasRepository {
    private List<Temporadas> temporadas = new ArrayList<>();

    public Temporadas buscarPorId(long code) {
        return temporadas.stream()
                .filter(p -> p.getIdTemporada() == code)
                .findFirst()
                .orElse(null);
    }

    public List<Temporadas> buscar() {
        return temporadas;
    }

    public void adicionar(Temporadas temporada) {
        temporadas.add(temporada);
    }

    public void remover(long code) {
        temporadas.removeIf(p -> p.getIdTemporada() == code);
    }

    public void atualizar(Long id, Temporadas novaTemporada) {
        Temporadas temporadaExistente = buscarPorId(id);

        if (temporadaExistente != null) {
            temporadaExistente.setNome(novaTemporada.getNome());
            temporadaExistente.setDescricao(novaTemporada.getDescricao());
            temporadaExistente.setData_inicio(novaTemporada.getData_inicio());
            temporadaExistente.setData_fim(novaTemporada.getData_fim());
        } else {
            System.out.println("Temporada com id " + id + " não encontrada.");
        }
    }
}
