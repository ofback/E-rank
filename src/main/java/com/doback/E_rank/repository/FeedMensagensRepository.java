package com.doback.E_rank.repository;

import com.doback.E_rank.entity.FeedMensagens;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FeedMensagensRepository {
    private List<FeedMensagens> feedMensagens = new ArrayList<>();

    public FeedMensagens buscarPorId(long code) {
        FeedMensagens feedMensagem = feedMensagens
                .stream()
                .filter(p -> p.getId_feed_mensagens() == code)
                .findFirst()
                .get();

        return feedMensagem;
    }

    public List<FeedMensagens> buscar(){
        return feedMensagens;
    }

    public void adicionar(FeedMensagens feedMensagem) {
        feedMensagens.add(feedMensagem);
    }

    public void remover(long code){
        feedMensagens.removeIf(p -> p.getId_feed_mensagens() == code);
    }

    public void atualizar(Long id, FeedMensagens novoFeedMensagens) {
        FeedMensagens feedMensagensExistente = buscarPorId(id);
        if (feedMensagensExistente != null) {
            feedMensagensExistente.setAtividade(novoFeedMensagens.getAtividade());
            feedMensagensExistente.setDescricao(novoFeedMensagens.getDescricao());
            feedMensagensExistente.setMensagem(novoFeedMensagens.getMensagem());
        }
    }
}
