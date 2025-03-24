package com.doback.E_rank.repository;

import com.doback.E_rank.entity.RegistroTemporadas;
import com.doback.E_rank.repository.jpa.RegistroTemporadasJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RegistroTemporadasImpl implements RegistroTemporadasRepository {
    private final RegistroTemporadasJpa registroTemporadasJpa;

    @Autowired
    public RegistroTemporadasImpl(RegistroTemporadasJpa registroTemporadasJpa) {
        this.registroTemporadasJpa = registroTemporadasJpa;
    }

    @Override
    public RegistroTemporadas searchByCode(long code) {
        return this.registroTemporadasJpa.findById((int) code).orElse(null);
    }

    @Override
    public RegistroTemporadas searchByCode(int id) {
        return null;
    }

    @Override
    public List<RegistroTemporadas> buscar() {
        return this.registroTemporadasJpa.findAll();
    }

    @Override
    public void addRegistroTemporadas(RegistroTemporadas registroTemporadas) {
        this.registroTemporadasJpa.save(registroTemporadas);
    }

    @Override
    public void removeRegistroTemporadas(int id) {

    }

    @Override
    public void updateRegistroTemporadas(int id, RegistroTemporadas registrotemporadas) {

    }

    @Override
    public void removeRegistroTemporadas(long code) {
        this.registroTemporadasJpa.deleteById(code);
    }

    @Override
    public void updateRegistroTemporadas(long code, RegistroTemporadas registroTemporadas) {
        RegistroTemporadas registroInDb = this.registroTemporadasJpa.findById(code).orElse(null);
        if (registroInDb != null) {
            this.registroTemporadasJpa.save(registroInDb);
        }
    }

    @Override
    public boolean estaVazio() {
        return this.registroTemporadasJpa.count() == 0;
    }
}
