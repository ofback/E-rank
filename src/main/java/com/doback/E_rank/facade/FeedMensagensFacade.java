package com.doback.E_rank.facade;

import com.doback.E_rank.entity.FeedMensagens;
import com.doback.E_rank.repository.FeedMensagensRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FeedMensagensFacade {

    private final FeedMensagensRepository feedMensagensRepository;

    public FeedMensagensFacade(FeedMensagensRepository feedMensagensRepository) {
        this.feedMensagensRepository = feedMensagensRepository;
    }

    public List<FeedMensagens> listarFeedMensagens() {
        return feedMensagensRepository.findAll();
    }

    public Optional<FeedMensagens> buscarFeedMensagemPorId(Long id) {
        return feedMensagensRepository.findById(id);
    }

    public FeedMensagens salvarFeedMensagem(FeedMensagens feedMensagens) {
        return feedMensagensRepository.save(feedMensagens);
    }

    public void excluirFeedMensagem(Long id) {
        feedMensagensRepository.deleteById(id);
    }
}
