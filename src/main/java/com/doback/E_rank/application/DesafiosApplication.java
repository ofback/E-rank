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

    public void criarDesafio(DesafiosModel desafiosModel) {
        validar(desafiosModel);
        desafioRepository.addDesafios(desafiosModel);
    }

    public void excluirDesafio(int id) {
        desafioRepository.removeDesafios(id);
    }

    public void atualizarDesafio(int id, DesafiosModel desafiosModel) {
        validar(desafiosModel);
        desafioRepository.updateDesafios(id, desafiosModel);
    }

    private Desafios validar (DesafiosModel desafiosModel){
        Desafios desafios = new Desafios(
                desafiosModel.getDataDesafio(),
                desafiosModel.getResultado(),
                desafiosModel.getSts(),
                desafiosModel.getIdAmizade(),
                desafiosModel.getIdJogo()
        );

        if (!desafios.validarDesafio()) {
            throw new IllegalArgumentException("Validação do desafio falhou: " + desafios.getErrosValidacao());
        }

        return desafios;
    }
}
