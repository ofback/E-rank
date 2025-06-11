package com.doback.E_rank.interfaces;

import com.doback.E_rank.infrastructure.models.AmizadesModel;

import java.util.List;

public interface AmizadesRepository {
    public AmizadesModel searchByCode(int id);
    public List<AmizadesModel> buscar();
    public void addAmizades(AmizadesModel AmizadesModel);
    public void removeAmizades(int id);
    public void updateAmizades(int id, AmizadesModel AmizadesModel);
    public boolean estaVazio();
}
