package com.doback.E_rank.interfaces;

import com.doback.E_rank.entity.Estatisticas;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EstatisticasRepository {
    public Estatisticas searchByCode(int id);
    public List<Estatisticas> buscar();
    public void addEstatisticas(Estatisticas estatisticas);
    public void removeEstatisticas(int id);
    public void updateEstatisticas(int id, Estatisticas estatisticas);
    public boolean estaVazio();

}
