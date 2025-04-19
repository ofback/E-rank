package com.doback.E_rank.interfaces;

import com.doback.E_rank.models.JogosModel;

import java.util.List;

public interface JogoRepository {
    public JogosModel searchByCode(int id);
    public List<JogosModel> buscar();
    public void addJogos(JogosModel jogosModel);
    public void removeJogos(int id);
    public void updateJogos(int id, JogosModel jogosModel);
    public boolean estaVazio();
}
