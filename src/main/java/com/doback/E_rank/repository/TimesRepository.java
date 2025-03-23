package com.doback.E_rank.repository;

import com.doback.E_rank.entity.Times;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TimesRepository {
    private List<Times> times = new ArrayList<>();

    public Times buscarPorId(long code) {
        Times time = times
                .stream()
                .filter(p -> p.getId_time() == code)
                .findFirst()
                .get();

        return time;
    }

    public List<Times> buscar(){
        return times;
    }

    public void adicionar(Times time) {
        times.add(time);
    }

    public void remover(long code){
        times.removeIf(p -> p.getId_time() == code);
    }

    public void atualizar(Long id, Times novoTime) {
        Times timeExistente = buscarPorId(id);
        if (timeExistente != null) {
            timeExistente.setNome(novoTime.getNome());
            timeExistente.setDescricao(novoTime.getDescricao());
            timeExistente.setSts(novoTime.getSts());
        }
    }

}
