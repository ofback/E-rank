package com.doback.E_rank.interfaces;

import com.doback.E_rank.infrastructure.models.EstatisticasModel;

import java.util.List;

public interface EstatisticasRepository {
    public EstatisticasModel searchByCode(int id);
    public List<EstatisticasModel> buscar();
    public void addEstatisticas(EstatisticasModel estatisticasModel);
    public void removeEstatisticas(int id);
    public void updateEstatisticas(int id, EstatisticasModel estatisticasModel);
    public boolean estaVazio();

}
