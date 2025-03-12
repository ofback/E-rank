package com.doback.E_rank.repository;

import com.doback.E_rank.entity.Amizade;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AmizadeRepository {
    private List<Amizade> amizades = new ArrayList<>();

    public Amizade buscarPorId(long code) {
        Amizade amizade = amizades
                .stream()
                .filter(p -> p.getIdAmizade() == code)
                .findFirst()
                .get();

        return amizade;
    }

    public List<Amizade> buscar(){
        return amizades;
    }

    public void adicionar(Amizade amizade) {
        amizades.add(amizade);
    }

    public void remover(long code){
        amizades.removeIf(p -> p.getIdAmizade() == code);
    }

    public void atualizar(long code, Amizade amizade){
        Amizade amizadeInMemory = this.buscarPorId(code);

        amizadeInMemory.setStatus(amizade.getStatus());
    }
}
