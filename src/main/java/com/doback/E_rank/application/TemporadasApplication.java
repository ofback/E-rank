package com.doback.E_rank.application;

import com.doback.E_rank.entity.Temporadas;
import com.doback.E_rank.repository.TemporadasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemporadasApplication {

    private final TemporadasRepository TemporadaRepository;

    public TemporadasApplication(TemporadasRepository temporadaRepository) {
        this.TemporadaRepository = temporadaRepository;
    }

    public static List<Temporadas> obterTodasTemporada() {
        return List.of();
    }

    public List<Temporadas> obterTodasTemporadas() {
        return TemporadaRepository.buscar();
    }

    public Temporadas obterTemporadasporid(long id) {
        TemporadasRepository temporadaRepository;
        return TemporadaRepository.buscarPorId(id);
    }

    public void criar(Temporadas temporada) {
        TemporadaRepository.adicionar(temporada);
    }

    public void excluirAmizade(Long id) {
        TemporadaRepository.remover(id);
    }

    public void criarTemporada(Temporadas temporada) {
        
    }

    public Temporadas obterTemporadaPorId(long id) {
        return TemporadaRepository.buscarPorId(id);
    }

    public void excluirTemporada(Long id) {
    }
}
