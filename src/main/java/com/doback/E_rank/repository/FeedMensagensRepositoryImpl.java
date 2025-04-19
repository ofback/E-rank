package com.doback.E_rank.repository;

import com.doback.E_rank.models.FeedMensagensModel;
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
    public FeedMensagensModel searchByCode(int code) {
        return this.feedMensagensJpa.findById(code).get();
    }

    @Override
    public List<FeedMensagensModel> buscar() {
        return this.feedMensagensJpa.findAll();
    }

    @Override
    public void addFeedMensagens(FeedMensagensModel feedMensagensModel) {
        this.feedMensagensJpa.save(feedMensagensModel);
    }

    @Override
    public void removeFeedMensagens(int code) {
        this.feedMensagensJpa.deleteById(code);
    }

    @Override
    public void updateFeedMensagens(int code, FeedMensagensModel feedMensagensModel) {
        FeedMensagensModel feedMensagensModelInDb = this.feedMensagensJpa.findById(code).get();

        if (feedMensagensModelInDb != null) {
            feedMensagensModelInDb.setAtividade(feedMensagensModel.getAtividade());
            feedMensagensModelInDb.setDescricao(feedMensagensModel.getDescricao());
            feedMensagensModelInDb.setMensagem(feedMensagensModel.getMensagem());
            feedMensagensModelInDb.setDataEnvio(feedMensagensModel.getDataEnvio());
            feedMensagensModelInDb.setStatus(feedMensagensModel.getStatus());

            this.feedMensagensJpa.save(feedMensagensModelInDb);
        }
    }

    @Override
    public boolean estaVazio() {
        return this.feedMensagensJpa.count() == 0;
    }
}
