package com.doback.E_rank.interfaces;

import com.doback.E_rank.models.RegistroTemporadasModel;


import java.util.List;

public interface RegistroTemporadasRepository {
    public RegistroTemporadasModel searchByCode(int id);
    public List<RegistroTemporadasModel> buscar();
    public void addRegistroTemporadas(RegistroTemporadasModel registrotemporadas);
    public void removeRegistroTemporadas(int id);
    public void updateRegistroTemporadas(int id, RegistroTemporadasModel registrotemporadas);
    public boolean estaVazio();


}
