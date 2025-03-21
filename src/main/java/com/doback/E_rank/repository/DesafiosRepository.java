package com.doback.E_rank.repository;

import com.doback.E_rank.entity.Desafios;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DesafiosRepository {
    private List<Desafios> desafios = new ArrayList<>();

    public Desafios buscarPorId(long code) {
        Desafios desafio = desafios
                .stream()
                .filter(p -> p.getIdDesafio() == code)
                .findFirst()
                .get();

        return desafio;
    }

    public List<Desafios> buscar(){
        return desafios;
    }

    public void adicionar(Desafios desafio) {
        desafios.add(desafio);
    }

    public void remover(long code){
        desafios.removeIf(p -> p.getIdDesafio() == code);
    }

    public void atualizar(long code, Desafios desafio){
        Desafios desafioInMemory = this.buscarPorId(code);

        desafioInMemory.setStatus(desafio.getStatus());
    }
}
