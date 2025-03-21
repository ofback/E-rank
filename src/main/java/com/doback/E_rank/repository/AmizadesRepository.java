package com.doback.E_rank.repository;

import com.doback.E_rank.entity.Amizades;
import com.doback.E_rank.entity.Estatisticas;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AmizadesRepository {
    private List<Amizades> amizades = new ArrayList<>();

    public Amizades buscarPorId(long code) {
        Amizades amizade = amizades
                .stream()
                .filter(p -> p.getAmizades() == code)
                .findFirst()
                .get();

        return amizade;
    }

    public List<Amizades> buscar(){
        return amizades;
    }

    public void adicionar(Amizades amizade) {
        amizades.add(amizade);
    }

    public void remover(long code){
        amizades.removeIf(p -> p.getAmizades() == code);
    }

    public void atualizar(Long id, Amizades novaAmizades) {
        Amizades amizadesAntigas = buscarPorId(id);
        if (amizadesAntigas != null) {
            amizadesAntigas.setUsuario1(novaAmizades.getUsuario1());
            amizadesAntigas.setUsuario2(novaAmizades.getUsuario2());
            amizadesAntigas.setStatus(novaAmizades.getStatus());
        }
    }
}
