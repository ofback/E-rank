package com.doback.E_rank.repository;

import com.doback.E_rank.entity.Jogos;
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
    public Jogos searchByCode(int code) {
        return this.jogoJpa.findById(code).get();
    }

    @Override
    public List<Jogos> buscar() {
        return this.jogoJpa.findAll();
    }

    @Override
    public void addJogos(Jogos jogos) {
        this.jogoJpa.save(jogos);
    }

    @Override
    public void removeJogos(int code) {
        this.jogoJpa.deleteById(code);
    }

    @Override
    public void updateJogos(int code, Jogos jogos) {
        Jogos jogosInDb = this.jogoJpa.findById(code).get();

        if (jogosInDb != null) {
            jogosInDb.setNome(jogos.getNome());
            jogosInDb.setDescricao(jogos.getDescricao());
            jogosInDb.setGenero(jogos.getGenero());

            this.jogoJpa.save(jogosInDb);
        }
    }

    @Override
    public boolean estaVazio() {
        return this.jogoJpa.count() == 0;
    }
}
