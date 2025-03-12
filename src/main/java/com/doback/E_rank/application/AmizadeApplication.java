package com.doback.E_rank.application;

import com.doback.E_rank.entity.Amizade;
import com.doback.E_rank.repository.AmizadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmizadeApplication {

    private final AmizadeRepository amizadeRepository;

    public AmizadeApplication(AmizadeRepository amizadeRepository) {
        this.amizadeRepository = amizadeRepository;
    }

    public List<Amizade> obterTodasAmizades() {
        return amizadeRepository.buscar();
    }

    public Amizade obterAmizadePorId(long id) {
        return amizadeRepository.buscarPorId(id);
    }

    public void criarAmizade(Amizade amizade) {
        amizadeRepository.adicionar(amizade);
    }

    public void excluirAmizade(Long id) {
        amizadeRepository.remover(id);
    }

}
