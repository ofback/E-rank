package com.doback.E_rank.interfaces;

import com.doback.E_rank.models.FeedMensagens;

import java.util.List;

public interface FeedMensagensRepository {
    public FeedMensagens searchByCode(int id);
    public List<FeedMensagens> buscar();
    public void addFeedMensagens(FeedMensagens feedMensagens);
    public void removeFeedMensagens(int id);
    public void updateFeedMensagens(int id, FeedMensagens FeedMensagens);
    public boolean estaVazio();

}
