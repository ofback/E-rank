package com.doback.E_rank.facade;

import com.doback.E_rank.entity.Desafio;
import com.doback.E_rank.repository.DesafioRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DesafioFacade {

    private final DesafioRepository desafioRepository;

    public DesafioFacade(DesafioRepository desafioRepository) {
        this.desafioRepository = desafioRepository;
    }

    public List<Desafio> listarDesafios() {
        return desafioRepository.findAll();
    }

    public Optional<Desafio> buscarDesafioPorId(Long id) {
        return desafioRepository.findById(id);
    }

    public List<Desafio> listarDesafiosPorStatus(Desafio.StatusDesafio status) {
        return desafioRepository.findByStatus(status);
    }

    public Desafio salvarDesafio(Desafio desafio) {
        return desafioRepository.save(desafio);
    }

    public void excluirDesafio(Long id) {
        desafioRepository.deleteById(id);
    }
}
