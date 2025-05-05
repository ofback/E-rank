package com.doback.E_rank.interfaces;

import com.doback.E_rank.entity.Desafios;
import com.doback.E_rank.models.DesafiosModel;

import java.util.List;

public interface DesafiosRepository {
    public DesafiosModel searchByCode(int code);
    public List<DesafiosModel> buscar();
    public void addDesafios(DesafiosModel desafiosModel);
    public void removeDesafios(int code);
    public void updateDesafios(int code, DesafiosModel desafiosModel);
    public boolean estaVazio();
}
