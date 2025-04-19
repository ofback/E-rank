package com.doback.E_rank.application;

import com.doback.E_rank.models.EstatisticasModel;
import com.doback.E_rank.interfaces.EstatisticasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstatisticasApplication {
    private final EstatisticasRepository estatisticaRepository;

    public EstatisticasApplication(EstatisticasRepository estatisticaRepository) {
        this.estatisticaRepository = estatisticaRepository;
    }

    public List<EstatisticasModel> obterTodas() {
        return estatisticaRepository.buscar();
    }

    public EstatisticasModel obterPorId(int id) {
        return estatisticaRepository.searchByCode(id);
    }

    public void criar(EstatisticasModel estatistica) {
        estatisticaRepository.addEstatisticas(estatistica);
    }

    public void excluir(int id) {
        estatisticaRepository.removeEstatisticas(id);
    }

    public void atualizar(int id, EstatisticasModel estatistica) {
        estatisticaRepository.updateEstatisticas(id, estatistica);
    }
}