package com.doback.E_rank.application;

import com.doback.E_rank.entity.Desafio;
import com.doback.E_rank.repository.DesafioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesafioApplication {
    private final DesafioRepository desafioRepository;

    public DesafioApplication(DesafioRepository desafioRepository) {
        this.desafioRepository = desafioRepository;
    }

    public List<Desafio> obterTodosDesafios() {
        return desafioRepository.buscar();
    }

    public Desafio obterDesafioPorId(long id) {
        return desafioRepository.buscarPorId(id);
    }

    public void criarDesafio(Desafio desafio) {
        desafioRepository.adicionar(desafio);
    }

    public void excluirDesafio(Long id) {
        desafioRepository.;
    }

}
