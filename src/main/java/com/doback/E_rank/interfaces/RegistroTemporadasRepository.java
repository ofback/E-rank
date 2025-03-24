package com.doback.E_rank.interfaces;
import com.doback.E_rank.entity.RegistroTemporadas;
import java.util.List;

public interface RegistroTemporadasRepository {
    public RegistroTemporadas searchByCode(int id);
    public List<RegistroTemporadas> buscar();
    public void addRegistroTemporadas(RegistroTemporadas registroTemporadas);
    public void removeRegistroTemporadas(int id);
    public void updateRegistroTemporadas(int id, RegistroTemporadas registroTemporadas);
    public boolean estaVazio();
}
