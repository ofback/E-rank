package com.doback.E_rank.application;
import com.doback.E_rank.models.FeedMensagens;
import com.doback.E_rank.interfaces.FeedMensagensRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class FeedMensagensApplication {
    private final FeedMensagensRepository feedMensagensRepository;

    public FeedMensagensApplication(FeedMensagensRepository feedMensagensRepository) {
        this.feedMensagensRepository = feedMensagensRepository;
    }

    public List<FeedMensagens> obterTodosFeedMensagens() {
        return feedMensagensRepository.buscar();
    }

    public FeedMensagens obterFeedMensagensPorId(int id) {
        return feedMensagensRepository.searchByCode(id);
    }

    public void criarFeedMensagens(FeedMensagens feedMensagens) {
        feedMensagensRepository.addFeedMensagens(feedMensagens);
    }

    public void excluirFeedMensagens(int id) {
        feedMensagensRepository.removeFeedMensagens(id);
    }

    public void atualizarFeedMensagens(int id, FeedMensagens feedMensagens) {
        feedMensagensRepository.updateFeedMensagens(id, feedMensagens);
    }
}
