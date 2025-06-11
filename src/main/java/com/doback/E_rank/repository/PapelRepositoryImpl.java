package com.doback.E_rank.repository;

import com.doback.E_rank.interfaces.PapelRepository;
import com.doback.E_rank.models.PapelModel;
import com.doback.E_rank.repository.jpa.PapelJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PapelRepositoryImpl implements PapelRepository {

    private final PapelJpa papelJpa;

    @Autowired
    public PapelRepositoryImpl(PapelJpa papelJpa) {
        this.papelJpa = papelJpa;
    }

    @Override
    public PapelModel findByNome(String nome) {
        return this.papelJpa.findByNome(nome);
    }

    @Override
    public void save(PapelModel papelModel) {
        this.papelJpa.save(papelModel);
    }
}