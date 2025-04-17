package com.doback.E_rank.repository;

import com.doback.E_rank.models.RegistroTemporadas;
import com.doback.E_rank.interfaces.RegistroTemporadasRepository;
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
    public RegistroTemporadas searchByCode(int id) {
        return this.registroTemporadasJpa.findById((int) id).orElse(null);
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
        this.registroTemporadasJpa.deleteById(id);

    }

    @Override
    public void updateRegistroTemporadas(int id, RegistroTemporadas registrotemporadas) {
        RegistroTemporadas registroInDb = this.registroTemporadasJpa.findById(id).orElse(null);
        if (registroInDb != null) {
            this.registroTemporadasJpa.save(registroInDb);
    }

}

    @Override
    public boolean estaVazio() {
        return false;
    }
}
