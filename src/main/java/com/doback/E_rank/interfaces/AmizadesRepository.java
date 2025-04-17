package com.doback.E_rank.interfaces;

import com.doback.E_rank.models.Amizades;

import java.util.List;

public interface AmizadesRepository {
    public Amizades searchByCode(int id);
    public List<Amizades> buscar();
    public void addAmizades(Amizades Amizades);
    public void removeAmizades(int id);
    public void updateAmizades(int id, Amizades Amizades);
    public boolean estaVazio();

}
