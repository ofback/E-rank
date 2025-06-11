package com.doback.E_rank.repository;

import com.doback.E_rank.models.RegistroTemporadasModel;
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
    public RegistroTemporadasModel searchByCode(int id) {
        return this.registroTemporadasJpa.findById((int) id).orElse(null);
    }

    @Override
    public List<RegistroTemporadasModel> buscar() {
        return this.registroTemporadasJpa.findAll();
    }

    @Override
    public void addRegistroTemporadas(RegistroTemporadasModel registroTemporadasModel) {
        this.registroTemporadasJpa.save(registroTemporadasModel);
    }

    @Override
    public void removeRegistroTemporadas(int id) {
        this.registroTemporadasJpa.deleteById(id);

    }

    @Override
    public void updateRegistroTemporadas(int id, RegistroTemporadasModel registrotemporadas) {
        RegistroTemporadasModel registroInDb = this.registroTemporadasJpa.findById(id).orElse(null);
        if (registroInDb != null) {
            this.registroTemporadasJpa.save(registroInDb);
    }

}

    @Override
    public boolean estaVazio() {
        return this.registroTemporadasJpa.count() == 0;
    }
}
