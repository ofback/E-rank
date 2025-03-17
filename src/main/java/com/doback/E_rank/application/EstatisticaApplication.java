package com.doback.E_rank.application;

import com.doback.E_rank.entity.Estatistica;
import com.doback.E_rank.repository.EstatisticaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstatisticaApplication {
    private final EstatisticaRepository estatisticaRepository;

    public EstatisticaApplication(EstatisticaRepository estatisticaRepository) {
        this.estatisticaRepository = estatisticaRepository;
    }

    public List<Estatistica> obterTodas() {
        return estatisticaRepository.buscarTodos();
    }

    public Estatistica obterPorId(Long id) {
        return estatisticaRepository.buscarPorId(id);
    }

    public void criar(Estatistica estatistica) {
        estatisticaRepository.salvar(estatistica);
    }

    public void excluir(Long id) {
        estatisticaRepository.remover(id);
    }

    public void atualizar(Long id, Estatistica estatistica) {
        estatisticaRepository.atualizar(id, estatistica);
    }
}