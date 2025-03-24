package com.doback.E_rank.interfaces;

import com.doback.E_rank.entity.VotacaoEstatisticas;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface VotacaoEstatisticasRepository {
    public VotacaoEstatisticas searchByCode(int id);
    public List<VotacaoEstatisticas> buscar();
    public void addVotacaoEstatisticas(VotacaoEstatisticas votacaoEstatisticas);
    public void removeVotacaoEstatisticas(int id);
    public void updateVotacaoEstatisticas(int id, VotacaoEstatisticas votacaoEstatisticas);
    public boolean estaVazio();
}
