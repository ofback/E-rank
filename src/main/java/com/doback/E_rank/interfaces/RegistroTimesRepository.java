package com.doback.E_rank.interfaces;

import com.doback.E_rank.models.RegistroTimesModel;

import java.util.List;

public interface RegistroTimesRepository {
    public RegistroTimesModel searchByCode(int code);
    public List<RegistroTimesModel> buscar();
    public void addRegistroTimes(RegistroTimesModel registroTimesModel);
    public void removeRegistroTimes(int code);
    public void updateRegistroTimes(int code, RegistroTimesModel registroTimesModel);
    public boolean estaVazio();
}
