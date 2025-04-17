package com.doback.E_rank.application;

import com.doback.E_rank.models.Desafios;
import com.doback.E_rank.interfaces.DesafiosRepository; // Importando a interface correta
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

    public Desafios obterDesafioPorId(int id) {
        return desafioRepository.searchByCode(id);
    }

    public void criarDesafio(Desafios desafio) {
        desafioRepository.addDesafios(desafio);
    }

    public void excluirDesafio(int id) {
        desafioRepository.removeDesafios(id);
    }

    public void atualizarDesafio(int id, Desafios desafio) {
        desafioRepository.updateDesafios(id, desafio); // Adicionado método de atualização
    }
}
