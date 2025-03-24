package com.doback.E_rank.application;

import com.doback.E_rank.entity.RegistroTemporadas;
import com.doback.E_rank.interfaces.RegistroTemporadasRepository;
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

    public RegistroTemporadas obterRegistrosTemporadaPorId(int id) {
        return registroTemporadasRepository.searchByCode(id);
    }

    public void criarRegistrosTemporada(RegistroTemporadas registroTemporadas) {
        registroTemporadasRepository.addRegistroTemporadas(registroTemporadas);
    }

    public void excluirRegistrosTemporada(int id) {
        registroTemporadasRepository.removeRegistroTemporadas(id);
    }

}
