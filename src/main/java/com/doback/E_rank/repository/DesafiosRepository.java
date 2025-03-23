package com.doback.E_rank.repository;

import com.doback.E_rank.entity.Desafios;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DesafiosRepository {
    private List<Desafios> desafios = new ArrayList<>();

    public Desafios buscarPorId(long code) {
        return desafios.stream()
                .filter(p -> p.getId_desafio() == code)
                .findFirst()
                .orElse(null);
    }

    public List<Desafios> buscar() {
        return desafios;
    }

    public void adicionar(Desafios desafio) {
        desafios.add(desafio);
    }

    public void remover(long code) {
        desafios.removeIf(p -> p.getId_desafio() == code);
    }

    public void atualizar(long code, Desafios desafioAtualizado) {
        Desafios desafioInMemory = this.buscarPorId(code);

        if (desafioInMemory != null) {
            desafioInMemory.setData_desafio(desafioAtualizado.getData_desafio());
            desafioInMemory.setResultado(desafioAtualizado.getResultado());
            desafioInMemory.setSts(desafioAtualizado.getSts());
        } else {
            System.out.println("Desafio com id " + code + " não encontrado.");
        }
    }
}
