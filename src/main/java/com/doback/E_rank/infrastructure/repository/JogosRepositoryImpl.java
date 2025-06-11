package com.doback.E_rank.infrastructure.repository;

import com.doback.E_rank.infrastructure.models.JogosModel;
import com.doback.E_rank.interfaces.JogosRepository;
import com.doback.E_rank.infrastructure.repository.jpa.JogosJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JogosRepositoryImpl implements JogosRepository {
    private final JogosJpa jogosJpa;

    @Autowired
    public JogosRepositoryImpl(JogosJpa jogosJpa) {
        this.jogosJpa = jogosJpa;
    }

    @Override
    public JogosModel searchByCode(int code) {
        return this.jogosJpa.findById(code).orElse(null);
    }

    @Override
    public List<JogosModel> buscar() {
        return this.jogosJpa.findAll();
    }

    @Override
    public void addJogos(JogosModel jogosModel) {
        this.jogosJpa.save(jogosModel);
    }

    @Override
    public void removeJogos(int code) {
        this.jogosJpa.deleteById(code);
    }

    @Override
    public void updateJogos(int code, JogosModel jogosModel) {
        JogosModel jogosModelInDb = this.jogosJpa.findById(code).orElse(null);

        if (jogosModelInDb != null) {
            jogosModelInDb.setNome(jogosModel.getNome());
            jogosModelInDb.setDescricao(jogosModel.getDescricao());
            jogosModelInDb.setGenero(jogosModel.getGenero());

            this.jogosJpa.save(jogosModelInDb);
        }
    }

    @Override
    public boolean estaVazio() {
        return this.jogosJpa.count() == 0;
    }
}

