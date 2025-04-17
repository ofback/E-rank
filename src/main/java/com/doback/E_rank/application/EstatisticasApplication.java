package com.doback.E_rank.application;

import com.doback.E_rank.models.Estatisticas;
import com.doback.E_rank.interfaces.EstatisticasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstatisticasApplication {
    private final EstatisticasRepository estatisticaRepository;

    public EstatisticasApplication(EstatisticasRepository estatisticaRepository) {
        this.estatisticaRepository = estatisticaRepository;
    }

    public List<Estatisticas> obterTodas() {
        return estatisticaRepository.buscar();
    }

    public Estatisticas obterPorId(int id) {
        return estatisticaRepository.searchByCode(id);
    }

    public void criar(Estatisticas estatistica) {
        estatisticaRepository.addEstatisticas(estatistica);
    }

    public void excluir(int id) {
        estatisticaRepository.removeEstatisticas(id);
    }

    public void atualizar(int id, Estatisticas estatistica) {
        estatisticaRepository.updateEstatisticas(id, estatistica);
    }
}