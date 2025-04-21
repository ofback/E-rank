package com.doback.E_rank.application;

import com.doback.E_rank.entity.RegistroTemporadas;
import com.doback.E_rank.models.RegistroTemporadasModel;
import com.doback.E_rank.interfaces.RegistroTemporadasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroTemporadasApplication {

    private final RegistroTemporadasRepository registroTemporadasRepository;

    public RegistroTemporadasApplication(RegistroTemporadasRepository registroTemporadasRepository) {
        this.registroTemporadasRepository = registroTemporadasRepository;
    }

    public List<RegistroTemporadasModel> obterTodosRegistrosTemporadas() {
        return registroTemporadasRepository.buscar();
    }

    public RegistroTemporadasModel obterRegistrosTemporadaPorId(int id) {
        return registroTemporadasRepository.searchByCode(id);
    }

    public void criarRegistrosTemporada(RegistroTemporadasModel registroTemporadasModel) {
        RegistroTemporadas registroTemporadasEntidade = new RegistroTemporadas(
                registroTemporadasModel.getData(),
                registroTemporadasModel.getIdTemporada(),
                registroTemporadasModel.getIdTime()
        );
        if (registroTemporadasEntidade.validarRegistroTemporadas()) {
            registroTemporadasRepository.addRegistroTemporadas(registroTemporadasModel);
        } else {
            throw new IllegalArgumentException("Validação do registroTemporadas falhou: " + registroTemporadasEntidade.getErrosValidacao());
        }
    }

    public void excluirRegistrosTemporada(int id) {
        registroTemporadasRepository.removeRegistroTemporadas(id);
    }

    public void atualizarRegistroTemporadas(int id, RegistroTemporadasModel registroTemporadasModel) {
        RegistroTemporadas registroTemporadasEntidade = new RegistroTemporadas(
                registroTemporadasModel.getData(),
                registroTemporadasModel.getIdTemporada(),
                registroTemporadasModel.getIdTime()
        );
        if (registroTemporadasEntidade.validarRegistroTemporadas()) {
            registroTemporadasRepository.addRegistroTemporadas(registroTemporadasModel);
        } else {
            throw new IllegalArgumentException("Validação do registroTemporadas falhou: " + registroTemporadasEntidade.getErrosValidacao());
        }
    }

}
