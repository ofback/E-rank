package com.doback.E_rank.interfaces;

import com.doback.E_rank.entity.RegistroTimes;

import java.util.List;

public interface RegistroTimesRepository {
    public RegistroTimes searchByCode(int code);
    public List<RegistroTimes> buscar();
    public void addRegistroTimes(RegistroTimes registroTimes);
    public void removeRegistroTimes(int code);
    public void updateRegistroTimes(int code, RegistroTimes registroTimes);
    public boolean estaVazio();
}
