package com.doback.E_rank.repository;

import com.doback.E_rank.entity.Amizade;
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
                .filter(p -> p.getIdTimes() == code)
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
        times.removeIf(p -> p.getIdTimes() == code);
    }

    public void atualizar(long code, Times time){
        Times timeInMemory = this.buscarPorId(code);

        timeInMemory.setStatus(time.getStatus());
    }

}
