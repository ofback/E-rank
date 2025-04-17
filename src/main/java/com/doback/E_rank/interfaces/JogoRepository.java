package com.doback.E_rank.interfaces;

import com.doback.E_rank.models.Jogos;

import java.util.List;

public interface JogoRepository {
    public Jogos searchByCode(int id);
    public List<Jogos> buscar();
    public void addJogos(Jogos jogos);
    public void removeJogos(int id);
    public void updateJogos(int id, Jogos jogos);
    public boolean estaVazio();
}
