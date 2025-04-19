package com.doback.E_rank.application;
import com.doback.E_rank.models.FeedMensagensModel;
import com.doback.E_rank.interfaces.FeedMensagensRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class FeedMensagensApplication {
    private final FeedMensagensRepository feedMensagensRepository;

    public FeedMensagensApplication(FeedMensagensRepository feedMensagensRepository) {
        this.feedMensagensRepository = feedMensagensRepository;
    }

    public List<FeedMensagensModel> obterTodosFeedMensagens() {
        return feedMensagensRepository.buscar();
    }

    public FeedMensagensModel obterFeedMensagensPorId(int id) {
        return feedMensagensRepository.searchByCode(id);
    }

    public void criarFeedMensagens(FeedMensagensModel feedMensagensModel) {
        feedMensagensRepository.addFeedMensagens(feedMensagensModel);
    }

    public void excluirFeedMensagens(int id) {
        feedMensagensRepository.removeFeedMensagens(id);
    }

    public void atualizarFeedMensagens(int id, FeedMensagensModel feedMensagensModel) {
        feedMensagensRepository.updateFeedMensagens(id, feedMensagensModel);
    }
}
