package com.doback.E_rank.interfaces;

import com.doback.E_rank.entity.Desafios;
import java.util.List;

public interface DesafiosRepository {
    public Desafios searchByCode(int code);
    public List<Desafios> buscar();
    public void addDesafios(Desafios desafios);
    public void removeDesafios(int code);
    public void updateDesafios(int code, Desafios desafios);
    public boolean estaVazio();
}
