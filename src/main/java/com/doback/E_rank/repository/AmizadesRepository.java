package com.doback.E_rank.repository;

import com.doback.E_rank.entity.Amizades;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AmizadesRepository {
    private List<Amizades> amizades = new ArrayList<>();

    public Amizades buscarPorId(long code) {
        Amizades amizade = amizades
                .stream()
                .filter(p -> p.getId_amizade() == code)
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
        amizades.removeIf(p -> p.getId_amizade() == code);
    }

    public void atualizar(Long id, Amizades novaAmizade) {
        Amizades amizadeAntiga = buscarPorId(id);

        if (amizadeAntiga != null) {
            amizadeAntiga.setId_usuario1(novaAmizade.getId_usuario1());
            amizadeAntiga.setId_usuario2(novaAmizade.getId_usuario2());
            amizadeAntiga.setSts(novaAmizade.getSts());
            amizadeAntiga.setData_solicitacao(novaAmizade.getData_solicitacao());
        } else {
            System.out.println("Amizade com id " + id + " não encontrada.");
        }
    }
}
