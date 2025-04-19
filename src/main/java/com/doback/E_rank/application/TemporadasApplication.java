package com.doback.E_rank.application;

import com.doback.E_rank.models.TemporadasModel;
import com.doback.E_rank.interfaces.TemporadasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemporadasApplication {

    private final TemporadasRepository TemporadaRepository;

    public TemporadasApplication(TemporadasRepository temporadaRepository) {
        this.TemporadaRepository = temporadaRepository;
    }

    public static List<TemporadasModel> obterTodasTemporada() {
        return List.of();
    }

    public List<TemporadasModel> obterTodasTemporadas() {
        return TemporadaRepository.buscar();
    }

    public TemporadasModel obterTemporadasporid(int id) {
        TemporadasRepository temporadaRepository;
        return TemporadaRepository.searchByCode(id);
    }

    public void criarTemporada(TemporadasModel temporada) {
        TemporadaRepository.addTemporadas(temporada);
    }

    public void excluirAmizade(int id) {
        TemporadaRepository.removeTemporadas(id);
    }


    public TemporadasModel obterTemporadaPorId(int id) {
        return TemporadaRepository.searchByCode(id);
    }

    public void excluirTemporada(Long id) {
    }

    public void atualizarTemporadas(int id, TemporadasModel temporadasModel) {
        TemporadaRepository.updateTemporadas(id, temporadasModel);
    }
}
