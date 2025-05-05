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
        validar(model);
        feedMensagensRepository.addFeedMensagens(model);
    }

    public void excluirFeedMensagens(int id) {
        FeedMensagensModel model = obterFeedMensagensPorId(id);
        feedMensagensRepository.removeFeedMensagens(model.getId());
    }

    public void atualizarFeedMensagens(int id, FeedMensagensModel model) {
        /*FeedMensagensModel existente = obterFeedMensagensPorId(id);*/
        validar(model);
        feedMensagensRepository.updateFeedMensagens(id, model);
    }

    private FeedMensagens validar (FeedMensagensModel feedMensagensModel){
        FeedMensagens feedMensagens = new FeedMensagens(
                feedMensagensModel.getAtividade(),
                feedMensagensModel.getDescricao(),
                feedMensagensModel.getMensagem(),
                feedMensagensModel.getStatus(),
                feedMensagensModel.getDataEnvio(),
                feedMensagensModel.getIdUsuario()
        );

        if (!feedMensagens.validarMensagem()) {
            throw new IllegalArgumentException("Validação da mensagem falhou: " + feedMensagens.getErrosValidacao());
        }

        return feedMensagens;
    }
}
