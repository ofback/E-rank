package com.doback.E_rank.facade;
import com.doback.E_rank.application.FeedMensagensApplication;
import com.doback.E_rank.models.FeedMensagensModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class FeedMensagensFacade {
    private final FeedMensagensApplication feedMensagensApplication;

    public FeedMensagensFacade(FeedMensagensApplication feedMensagensApplication) {
        this.feedMensagensApplication = feedMensagensApplication;
    }

    public List<FeedMensagensModel> listarFeedMensagens() {
        return feedMensagensApplication.obterTodosFeedMensagens();
    }

    public FeedMensagensModel buscarFeedMensagensPorId(int id) {
        return feedMensagensApplication.obterFeedMensagensPorId(id);
    }

    public void salvarFeedMensagens(FeedMensagensModel feedMensagensModel) {
        feedMensagensApplication.criarFeedMensagens(feedMensagensModel);
    }

    public void excluirFeedMensagens(int id) {
        feedMensagensApplication.excluirFeedMensagens(id);
    }

    public void atualizarFeedMensagens(int id, FeedMensagensModel feedMensagensModel) {
        feedMensagensApplication.atualizarFeedMensagens(id, feedMensagensModel);
    }
}
