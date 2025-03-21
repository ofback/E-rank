package com.doback.E_rank.application;

import com.doback.E_rank.entity.Desafios;
import com.doback.E_rank.repository.DesafiosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesafiosApplication {
    private final DesafiosRepository desafioRepository;

    public DesafiosApplication(DesafiosRepository desafioRepository) {
        this.desafioRepository = desafioRepository;
    }

    public List<Desafios> obterTodosDesafios() {
        return desafioRepository.buscar();
    }

    public Desafios obterDesafioPorId(long id) {
        return desafioRepository.buscarPorId(id);
    }

    public void criarDesafio(Desafios desafio) {
        desafioRepository.adicionar(desafio);
    }

    public void excluirDesafio(Long id) {
        desafioRepository.remover(id);
    }

}
