package com.doback.E_rank.application;

import com.doback.E_rank.models.Temporadas;
import com.doback.E_rank.interfaces.TemporadasRepository;
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

    public Temporadas obterTemporadasporid(int id) {
        TemporadasRepository temporadaRepository;
        return TemporadaRepository.searchByCode(id);
    }

    public void criarTemporada(Temporadas temporada) {
        TemporadaRepository.addTemporadas(temporada);
    }

    public void excluirAmizade(int id) {
        TemporadaRepository.removeTemporadas(id);
    }


    public Temporadas obterTemporadaPorId(int id) {
        return TemporadaRepository.searchByCode(id);
    }

    public void excluirTemporada(Long id) {
    }

    public void atualizarTemporadas(int id, Temporadas temporadas) {
        TemporadaRepository.updateTemporadas(id, temporadas);
    }
}
