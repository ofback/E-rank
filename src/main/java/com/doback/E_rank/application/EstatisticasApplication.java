package com.doback.E_rank.application;

import com.doback.E_rank.entity.Estatisticas;
import com.doback.E_rank.repository.EstatisticasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstatisticasApplication {
    private final EstatisticasRepository estatisticaRepository;

    public EstatisticasApplication(EstatisticasRepository estatisticaRepository) {
        this.estatisticaRepository = estatisticaRepository;
    }

    public List<Estatisticas> obterTodas() {
        return estatisticaRepository.buscarTodos();
    }

    public Estatisticas obterPorId(Long id) {
        return estatisticaRepository.buscarPorId(id);
    }

    public void criar(Estatisticas estatistica) {
        estatisticaRepository.salvar(estatistica);
    }

    public void excluir(Long id) {
        estatisticaRepository.remover(id);
    }

    public void atualizar(Long id, Estatisticas estatistica) {
        estatisticaRepository.atualizar(id, estatistica);
    }
}