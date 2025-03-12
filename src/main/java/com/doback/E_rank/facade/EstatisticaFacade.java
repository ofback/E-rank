package com.doback.E_rank.facade;

import com.doback.E_rank.entity.Estatistica;
import com.doback.E_rank.repository.EstatisticaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EstatisticaFacade {

    private final EstatisticaRepository estatisticaRepository;

    public EstatisticaFacade(EstatisticaRepository estatisticaRepository) {
        this.estatisticaRepository = estatisticaRepository;
    }

    public List<Estatistica> listarEstatisticas() {
        return estatisticaRepository.findAll();
    }

    public Optional<Estatistica> buscarEstatisticaPorId(Long id) {
        return estatisticaRepository.findById(id);
    }

    public Estatistica salvarEstatistica(Estatistica estatistica) {
        return estatisticaRepository.save(estatistica);
    }

    public void excluirEstatistica(Long id) {
        estatisticaRepository.deleteById(id);
    }
}
