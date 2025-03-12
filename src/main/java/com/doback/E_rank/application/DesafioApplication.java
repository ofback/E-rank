package com.doback.E_rank.application;

import com.doback.E_rank.entity.Desafio;
import com.doback.E_rank.facade.DesafioFacade;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DesafioApplication {

    private final DesafioFacade desafioFacade;

    public DesafioApplication(DesafioFacade desafioFacade) {
        this.desafioFacade = desafioFacade;
    }

    public List<Desafio> obterTodosDesafios() {
        return desafioFacade.listarDesafios();
    }

    public Optional<Desafio> obterDesafioPorId(Long id) {
        return desafioFacade.buscarDesafioPorId(id);
    }

    public List<Desafio> obterDesafiosPorStatus(Desafio.StatusDesafio status) {
        return desafioFacade.listarDesafiosPorStatus(status);
    }

    public Desafio criarDesafio(Desafio desafio) {
        return desafioFacade.salvarDesafio(desafio);
    }

    public void excluirDesafio(Long id) {
        desafioFacade.excluirDesafio(id);
    }
}
