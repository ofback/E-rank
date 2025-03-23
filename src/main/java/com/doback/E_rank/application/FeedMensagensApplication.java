package com.doback.E_rank.application;
import com.doback.E_rank.entity.FeedMensagens;
import com.doback.E_rank.repository.FeedMensagensRepository;
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

    public FeedMensagens obterFeedMensagensPorId(long id) {
        return feedMensagensRepository.buscarPorId(id);
    }

    public void criarFeedMensagens(FeedMensagens feedMensagens) {
        feedMensagensRepository.adicionar(feedMensagens);
    }

    public void excluirFeedMensagens(Long id) {
        feedMensagensRepository.remover(id);
    }

    public void atualizarFeedMensagens(Long id, FeedMensagens feedMensagens) {
        feedMensagensRepository.atualizar(id, feedMensagens);
    }
}
