package com.doback.E_rank.interfaces;

import com.doback.E_rank.models.TimesModel;

import java.util.List;

public interface TimesRepository {
    public TimesModel searchByCode(int code);
    public List<TimesModel> buscar();
    public void addTimes(TimesModel timesModel);
    public void removeTimes(int code);
    public void updateTimes(int code, TimesModel timesModel);
    public boolean estaVazio();
}

