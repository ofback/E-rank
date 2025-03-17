package com.doback.E_rank.repository;

import com.doback.E_rank.entity.Desafio;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DesafioRepository {
    private List<Desafio> desafios = new ArrayList<>();

    public Desafio buscarPorId(long code) {
        Desafio desafio = desafios
                .stream()
                .filter(p -> p.getIdDesafio() == code)
                .findFirst()
                .get();

        return desafio;
    }

    public List<Desafio> buscar(){
        return desafios;
    }

    public void adicionar(Desafio desafio) {
        desafios.add(desafio);
    }

    public void remover(long code){
        desafios.removeIf(p -> p.getIdDesafio() == code);
    }

    public void atualizar(long code, Desafio desafio){
        Desafio desafioInMemory = this.buscarPorId(code);

        desafioInMemory.setStatus(desafio.getStatus());
    }
}
