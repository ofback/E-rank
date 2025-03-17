package com.doback.E_rank.facade;

import com.doback.E_rank.application.DesafioApplication;
import com.doback.E_rank.entity.Desafio;
import com.doback.E_rank.repository.DesafioRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DesafioFacade {

    private final DesafioApplication desafioApplication;

    public DesafioFacade(DesafioApplication desafioApplication) {
        this.desafioApplication = desafioApplication;
    }

    public List<Desafio> listarDesafios() {
        return desafioApplication.obterTodosDesafios();
    }

    public Desafio buscarDesafioPorId(Long id) {
        return desafioApplication.obterDesafioPorId(id);
    }

    public void salvarDesafio(Desafio desafio) {
        desafioApplication.criarDesafio(desafio);
    }

    public void excluirDesafio(Long id) {
        desafioApplication.excluirDesafio(id);
    }
}
