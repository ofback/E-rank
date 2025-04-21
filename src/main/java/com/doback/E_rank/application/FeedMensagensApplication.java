package com.doback.E_rank.application;

import com.doback.E_rank.entity.FeedMensagens;
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
        FeedMensagensModel model = feedMensagensRepository.searchByCode(id);
        if (model == null) {
            throw new IllegalArgumentException("Mensagem não encontrada.");
        }
        return model;
    }

    public void criarFeedMensagens(FeedMensagensModel model) {
        FeedMensagens feed = new FeedMensagens(
                model.getAtividade(),
                model.getDescricao(),
                model.getMensagem(),
                model.getStatus(),
                model.getDataEnvio(),
                model.getIdUsuario()
        );

        if (feed.validarMensagem()) {
            feedMensagensRepository.addFeedMensagens(model);
        } else {
            throw new IllegalArgumentException("Validação da mensagem falhou: " + feed.getErrosValidacao());
        }
    }

    public void excluirFeedMensagens(int id) {
        FeedMensagensModel model = obterFeedMensagensPorId(id);
        feedMensagensRepository.removeFeedMensagens(model.getId());
    }

    public void atualizarFeedMensagens(int id, FeedMensagensModel model) {
        FeedMensagensModel existente = obterFeedMensagensPorId(id);

        FeedMensagens feed = new FeedMensagens(
                model.getAtividade(),
                model.getDescricao(),
                model.getMensagem(),
                model.getStatus(),
                model.getDataEnvio(),
                model.getIdUsuario()
        );

        if (feed.validarMensagem()) {
            feedMensagensRepository.updateFeedMensagens(id, model);
        } else {
            throw new IllegalArgumentException("Validação da mensagem falhou: " + feed.getErrosValidacao());
        }
    }
}
