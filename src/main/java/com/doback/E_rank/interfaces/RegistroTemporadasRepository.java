package com.doback.E_rank.interfaces;

import com.doback.E_rank.models.RegistroTemporadas;


import java.util.List;

public interface RegistroTemporadasRepository {
    public RegistroTemporadas searchByCode(int id);
    public List<RegistroTemporadas> buscar();
    public void addRegistroTemporadas(RegistroTemporadas registrotemporadas);
    public void removeRegistroTemporadas(int id);
    public void updateRegistroTemporadas(int id, RegistroTemporadas registrotemporadas);
    public boolean estaVazio();


}
