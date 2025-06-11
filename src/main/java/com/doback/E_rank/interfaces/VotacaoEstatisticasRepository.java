package com.doback.E_rank.interfaces;

import com.doback.E_rank.infrastructure.models.VotacaoEstatisticasModel;

import java.util.List;

public interface VotacaoEstatisticasRepository {
    public VotacaoEstatisticasModel searchByCode(int id);
    public List<VotacaoEstatisticasModel> buscar();
    public void addVotacaoEstatisticas(VotacaoEstatisticasModel votacaoEstatisticasModel);
    public void removeVotacaoEstatisticas(int id);
    public void updateVotacaoEstatisticas(int id, VotacaoEstatisticasModel votacaoEstatisticasModel);
    public boolean estaVazio();
}
