package com.doback.E_rank.facade;

import com.doback.E_rank.entity.MembroDoTime;
import com.doback.E_rank.repository.MembroDoTimeRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MembroDoTimeFacade {

    private final MembroDoTimeRepository membroDoTimeRepository;

    public MembroDoTimeFacade(MembroDoTimeRepository membroDoTimeRepository) {
        this.membroDoTimeRepository = membroDoTimeRepository;
    }

    public List<MembroDoTime> listarMembros() {
        return membroDoTimeRepository.findAll();
    }

    public Optional<MembroDoTime> buscarMembroPorId(Long id) {
        return membroDoTimeRepository.findById(id);
    }

    public MembroDoTime salvarMembro(MembroDoTime membroDoTime) {
        return membroDoTimeRepository.save(membroDoTime);
    }

    public void excluirMembro(Long id) {
        membroDoTimeRepository.deleteById(id);
    }
}
