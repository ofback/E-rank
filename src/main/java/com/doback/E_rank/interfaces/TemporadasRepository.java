package com.doback.E_rank.interfaces;

import com.doback.E_rank.entity.Temporadas;

import java.util.List;

public interface TemporadasRepository {
    public Temporadas searchByCode(int id);
    public List<Temporadas> buscar();
    public void addTemporadas(Temporadas temporadas);
    public void removeTemporadas(int id);
    public void updateTemporadas(int id, Temporadas temporadas);
    public boolean estaVazio();

}
