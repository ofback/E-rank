package com.doback.E_rank.interfaces;

import com.doback.E_rank.models.FeedMensagensModel;

import java.util.List;

public interface FeedMensagensRepository {
    public FeedMensagensModel searchByCode(int id);
    public List<FeedMensagensModel> buscar();
    public void addFeedMensagens(FeedMensagensModel feedMensagensModel);
    public void removeFeedMensagens(int id);
    public void updateFeedMensagens(int id, FeedMensagensModel FeedMensagensModel);
    public boolean estaVazio();

}
