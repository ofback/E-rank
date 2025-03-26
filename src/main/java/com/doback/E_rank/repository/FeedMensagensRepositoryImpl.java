package com.doback.E_rank.repository;

import com.doback.E_rank.entity.FeedMensagens;
import com.doback.E_rank.interfaces.FeedMensagensRepository;
import com.doback.E_rank.repository.jpa.FeedMensagensJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FeedMensagensRepositoryImpl implements FeedMensagensRepository {
    private final FeedMensagensJpa feedMensagensJpa;

    @Autowired
    public FeedMensagensRepositoryImpl(FeedMensagensJpa feedMensagensJpa) {
        this.feedMensagensJpa = feedMensagensJpa;
    }

    @Override
    public FeedMensagens searchByCode(int code) {
        return this.feedMensagensJpa.findById(code).get();
    }

    @Override
    public List<FeedMensagens> buscar() {
        return this.feedMensagensJpa.findAll();
    }

    @Override
    public void addFeedMensagens(FeedMensagens feedMensagens) {
        this.feedMensagensJpa.save(feedMensagens);
    }

    @Override
    public void removeFeedMensagens(int code) {
        this.feedMensagensJpa.deleteById(code);
    }

    @Override
    public void updateFeedMensagens(int code, FeedMensagens feedMensagens) {
        FeedMensagens feedMensagensInDb = this.feedMensagensJpa.findById(code).get();

        if (feedMensagensInDb != null) {
            feedMensagensInDb.setAtividade(feedMensagens.getAtividade());
            feedMensagensInDb.setDescricao(feedMensagens.getDescricao());
            feedMensagensInDb.setMensagem(feedMensagens.getMensagem());
            feedMensagensInDb.setDataEnvio(feedMensagens.getDataEnvio());
            feedMensagensInDb.setStatus(feedMensagens.getStatus());

            this.feedMensagensJpa.save(feedMensagensInDb);
        }
    }

    @Override
    public boolean estaVazio() {
        return this.feedMensagensJpa.count() == 0;
    }
}
