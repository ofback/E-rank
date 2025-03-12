package com.doback.E_rank.facade;

import com.doback.E_rank.entity.Temporada;
import com.doback.E_rank.repository.TemporadaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TemporadaFacade {

    private final TemporadaRepository temporadaRepository;

    public TemporadaFacade(TemporadaRepository temporadaRepository) {
        this.temporadaRepository = temporadaRepository;
    }

    public List<Temporada> listarTemporadas() {
        return temporadaRepository.findAll();
    }

    public Optional<Temporada> buscarTemporadaPorId(Long id) {
        return temporadaRepository.findById(id);
    }

    public Temporada salvarTemporada(Temporada temporada) {
        return temporadaRepository.save(temporada);
    }

    public void excluirTemporada(Long id) {
        temporadaRepository.deleteById(id);
    }
}
