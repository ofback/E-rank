package com.doback.E_rank.application;

import com.doback.E_rank.entity.FeedMensagens;
import com.doback.E_rank.facade.FeedMensagensFacade;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedMensagensApplication {

    private final FeedMensagensFacade feedMensagensFacade;

    public FeedMensagensApplication(FeedMensagensFacade feedMensagensFacade) {
        this.feedMensagensFacade = feedMensagensFacade;
    }

    public List<FeedMensagens> obterTodosFeedMensagens() {
        return feedMensagensFacade.listarFeedMensagens();
    }

    public Optional<FeedMensagens> obterFeedMensagemPorId(Long id) {
        return feedMensagensFacade.buscarFeedMensagemPorId(id);
    }

    public FeedMensagens criarFeedMensagem(FeedMensagens feedMensagens) {
        return feedMensagensFacade.salvarFeedMensagem(feedMensagens);
    }

    public void excluirFeedMensagem(Long id) {
        feedMensagensFacade.excluirFeedMensagem(id);
    }
}
