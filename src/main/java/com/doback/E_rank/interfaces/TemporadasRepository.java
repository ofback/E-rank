package com.doback.E_rank.interfaces;

import com.doback.E_rank.entity.Temporadas;
import com.doback.E_rank.models.TemporadasModel;

import java.util.List;

public interface TemporadasRepository {
    public TemporadasModel searchByCode(int id);
    public List<TemporadasModel> buscar();
    public void addTemporadas(TemporadasModel temporadasModel);
    public void removeTemporadas(int id);
    public void updateTemporadas(int id, TemporadasModel temporadasModel);
    public boolean estaVazio();

}
