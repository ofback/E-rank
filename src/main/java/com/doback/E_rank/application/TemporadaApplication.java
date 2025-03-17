package com.doback.E_rank.application;

import com.doback.E_rank.entity.Temporada;
import com.doback.E_rank.repository.TemporadaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemporadaApplication {

    private final TemporadaRepository TemporadaRepository;

    public TemporadaApplication(TemporadaRepository temporadaRepository) {
        this.TemporadaRepository = temporadaRepository;
    }

    public static List<Temporada> obterTodasTemporada() {
        return List.of();
    }

    public List<Temporada> obterTodasTemporadas() {
        return TemporadaRepository.buscar();
    }

    public Temporada obterTemporadasporid(long id) {
        TemporadaRepository temporadaRepository;
        return TemporadaRepository.buscarPorId(id);
    }

    public void criar(Temporada temporada) {
        TemporadaRepository.adicionar(temporada);
    }

    public void excluirAmizade(Long id) {
        TemporadaRepository.remover(id);
    }

    public void criarTemporada(Temporada temporada) {
        
    }

    public Temporada obterTemporadaPorId(long id) {
        return TemporadaRepository.buscarPorId(id);
    }

    public void excluirTemporada(Long id) {
    }
}
