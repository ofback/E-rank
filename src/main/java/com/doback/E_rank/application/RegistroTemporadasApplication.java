package com.doback.E_rank.application;

import com.doback.E_rank.entity.RegistroTemporadas;
import com.doback.E_rank.repository.RegistroTemporadasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroTemporadasApplication {

    private final RegistroTemporadasRepository registroTemporadasRepository;

    public RegistroTemporadasApplication(RegistroTemporadasRepository registroTemporadasRepository) {
        this.registroTemporadasRepository = registroTemporadasRepository;
    }

    public List<RegistroTemporadas> obterTodosRegistrosTemporadas() {
        return registroTemporadasRepository.buscar();
    }

    public RegistroTemporadas obterRegistrosTemporadaPorId(long id) {
        return registroTemporadasRepository.buscarPorId(id);
    }

    public void criarRegistrosTemporada(RegistroTemporadas registroTemporadas) {
        registroTemporadasRepository.adicionar(registroTemporadas);
    }

    public void excluirRegistrosTemporada(Long id) {
        registroTemporadasRepository.remover(id);
    }

}
