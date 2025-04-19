package com.doback.E_rank.repository;

import com.doback.E_rank.models.JogosModel;
import com.doback.E_rank.interfaces.JogoRepository;
import com.doback.E_rank.repository.jpa.JogoJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JogosRepositoryImpl implements JogoRepository {
    private final JogoJpa jogoJpa;

    @Autowired
    public JogosRepositoryImpl(JogoJpa jogoJpa) {
        this.jogoJpa = jogoJpa;
    }

    @Override
    public JogosModel searchByCode(int code) {
        return this.jogoJpa.findById(code).get();
    }

    @Override
    public List<JogosModel> buscar() {
        return this.jogoJpa.findAll();
    }

    @Override
    public void addJogos(JogosModel jogosModel) {
        this.jogoJpa.save(jogosModel);
    }

    @Override
    public void removeJogos(int code) {
        this.jogoJpa.deleteById(code);
    }

    @Override
    public void updateJogos(int code, JogosModel jogosModel) {
        JogosModel jogosModelInDb = this.jogoJpa.findById(code).get();

        if (jogosModelInDb != null) {
            jogosModelInDb.setNome(jogosModel.getNome());
            jogosModelInDb.setDescricao(jogosModel.getDescricao());
            jogosModelInDb.setGenero(jogosModel.getGenero());

            this.jogoJpa.save(jogosModelInDb);
        }
    }

    @Override
    public boolean estaVazio() {
        return this.jogoJpa.count() == 0;
    }
}
