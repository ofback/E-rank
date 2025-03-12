package com.doback.E_rank.facade;

import com.doback.E_rank.entity.Amizade;
import com.doback.E_rank.repository.AmizadeRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AmizadeFacade {

    private final AmizadeRepository amizadeRepository;

    public AmizadeFacade(AmizadeRepository amizadeRepository) {
        this.amizadeRepository = amizadeRepository;
    }

    public List<Amizade> listarAmizades() {
        return amizadeRepository.findAll();
    }

    public Optional<Amizade> buscarAmizadePorId(Long id) {
        return amizadeRepository.findById(id);
    }

    public Amizade salvarAmizade(Amizade amizade) {
        return amizadeRepository.save(amizade);
    }

    public void excluirAmizade(Long id) {
        amizadeRepository.deleteById(id);
    }
}
