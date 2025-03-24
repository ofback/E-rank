package com.doback.E_rank.facade;

import com.doback.E_rank.application.DesafiosApplication;
import com.doback.E_rank.entity.Desafios;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DesafiosFacade {

    private final DesafiosApplication desafioApplication;

    public DesafiosFacade(DesafiosApplication desafioApplication) {
        this.desafioApplication = desafioApplication;
    }

    public List<Desafios> listarDesafios() {
        return desafioApplication.obterTodosDesafios();
    }

    public Desafios buscarDesafioPorId(int id) {
        return desafioApplication.obterDesafioPorId(id);
    }

    public void salvarDesafio(Desafios desafio) {
        desafioApplication.criarDesafio(desafio);
    }

    public void excluirDesafio(int id) {
        desafioApplication.excluirDesafio(id);
    }
}
