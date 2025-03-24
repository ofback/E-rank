package com.doback.E_rank.interfaces;

import com.doback.E_rank.entity.Times;

import java.util.List;

public interface TimesRepository {
    public Times searchByCode(int code);
    public List<Times> buscar();
    public void addTimes(Times times);
    public void removeTimes(int code);
    public void updateTimes(int code, Times times);
    public boolean estaVazio();
}
