package com.doback.E_rank.application;

import com.doback.E_rank.entity.Desafios;
import com.doback.E_rank.models.DesafiosModel;
import com.doback.E_rank.interfaces.DesafiosRepository; // Importando a interface correta
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesafiosApplication {
    private final DesafiosRepository desafioRepository;

    public DesafiosApplication(DesafiosRepository desafioRepository) {
        this.desafioRepository = desafioRepository;
    }

    public List<DesafiosModel> obterTodosDesafios() {
        return desafioRepository.buscar();
    }

    public DesafiosModel obterDesafioPorId(int id) {
        return desafioRepository.searchByCode(id);
    }

    public void criarDesafio(Desafios desafio) {
        desafioRepository.addDesafios(desafio);
    }

    public void excluirDesafio(int id) {
        desafioRepository.removeDesafios(id);
    }

    public void atualizarDesafio(int id, DesafiosModel desafio) {
        desafioRepository.updateDesafios(id, desafio);
    }
}
