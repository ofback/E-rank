package com.doback.E_rank.application;

import com.doback.E_rank.entity.MembroDoTime;
import com.doback.E_rank.facade.MembroDoTimeFacade;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MembroDoTimeApplication {

    private final MembroDoTimeFacade membroDoTimeFacade;

    public MembroDoTimeApplication(MembroDoTimeFacade membroDoTimeFacade) {
        this.membroDoTimeFacade = membroDoTimeFacade;
    }

    public List<MembroDoTime> obterTodosMembros() {
        return membroDoTimeFacade.listarMembros();
    }

    public Optional<MembroDoTime> obterMembroPorId(Long id) {
        return membroDoTimeFacade.buscarMembroPorId(id);
    }

    public MembroDoTime criarMembro(MembroDoTime membroDoTime) {
        return membroDoTimeFacade.salvarMembro(membroDoTime);
    }

    public void excluirMembro(Long id) {
        membroDoTimeFacade.excluirMembro(id);
    }
}
