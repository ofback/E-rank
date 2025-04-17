package com.doback.E_rank.interfaces;

import com.doback.E_rank.models.VotacaoEstatisticas;

import java.util.List;

public interface VotacaoEstatisticasRepository {
    public VotacaoEstatisticas searchByCode(int id);
    public List<VotacaoEstatisticas> buscar();
    public void addVotacaoEstatisticas(VotacaoEstatisticas votacaoEstatisticas);
    public void removeVotacaoEstatisticas(int id);
    public void updateVotacaoEstatisticas(int id, VotacaoEstatisticas votacaoEstatisticas);
    public boolean estaVazio();
}
