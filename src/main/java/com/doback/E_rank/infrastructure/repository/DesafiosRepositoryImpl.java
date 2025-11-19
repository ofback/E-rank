// E-rank/src/main/java/com/doback/E_rank/infrastructure/repository/DesafiosRepositoryImpl.java
package com.doback.E_rank.infrastructure.repository;

import com.doback.E_rank.infrastructure.models.DesafiosModel;
import com.doback.E_rank.interfaces.DesafiosRepository;
import com.doback.E_rank.infrastructure.repository.jpa.DesafiosJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DesafiosRepositoryImpl implements DesafiosRepository {
    private final DesafiosJpa desafiosJpa;

    @Autowired
    public DesafiosRepositoryImpl(DesafiosJpa desafiosJpa) {
        this.desafiosJpa = desafiosJpa;
    }

    @Override
    public DesafiosModel searchByCode(int code) {
        return this.desafiosJpa.findById(code).orElse(null); // Uso de orElse para evitar erro se não achar
    }

    @Override
    public List<DesafiosModel> buscar() {
        return this.desafiosJpa.findAll();
    }

    @Override
    public void addDesafios(DesafiosModel desafiosModel) {
        this.desafiosJpa.save(desafiosModel);
    }

    @Override
    public void removeDesafios(int code) {
        this.desafiosJpa.deleteById(code);
    }

    @Override
    public void updateDesafios(int code, DesafiosModel desafiosModel) {
        // Busca o objeto no banco
        DesafiosModel desafiosModelInDb = this.desafiosJpa.findById(code)
                .orElseThrow(() -> new RuntimeException("Desafio não encontrado para atualização"));

        // CORREÇÃO: Usando os nomes corretos dos Getters/Setters do Model atualizado
        desafiosModelInDb.setDataHora(desafiosModel.getDataHora()); // Era setDataDesafio
        desafiosModelInDb.setResultado(desafiosModel.getResultado());
        desafiosModelInDb.setStatus(desafiosModel.getStatus());     // Era setSts

        this.desafiosJpa.save(desafiosModelInDb);
    }

    @Override
    public boolean estaVazio() {
        return this.desafiosJpa.count() == 0;
    }
}