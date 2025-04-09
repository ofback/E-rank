package com.doback.E_rank.facade;
import com.doback.E_rank.application.FeedMensagensApplication;
import com.doback.E_rank.entity.FeedMensagens;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class FeedMensagensFacade {
    private final FeedMensagensApplication feedMensagensApplication;

    public FeedMensagensFacade(FeedMensagensApplication feedMensagensApplication) {
        this.feedMensagensApplication = feedMensagensApplication;
    }

    public List<FeedMensagens> listarFeedMensagens() {
        return feedMensagensApplication.obterTodosFeedMensagens();
    }

    public FeedMensagens buscarFeedMensagensPorId(int id) {
        return feedMensagensApplication.obterFeedMensagensPorId(id);
    }

    public void salvarFeedMensagens(FeedMensagens feedMensagens) {
        feedMensagensApplication.criarFeedMensagens(feedMensagens);
    }

    public void excluirFeedMensagens(int id) {
        feedMensagensApplication.excluirFeedMensagens(id);
    }

    public void atualizarFeedMensagens(int id, FeedMensagens feedMensagens) {
        feedMensagensApplication.atualizarFeedMensagens(id, feedMensagens);
    }
}
