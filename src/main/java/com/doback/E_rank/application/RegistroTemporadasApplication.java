package com.doback.E_rank.application;

import com.doback.E_rank.entity.RegistroTemporadas;
import com.doback.E_rank.infrastructure.models.RegistroTemporadasModel;
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
        validar(registroTemporadasModel);
        registroTemporadasRepository.addRegistroTemporadas(registroTemporadasModel);
    }

    public void excluirRegistrosTemporada(int id) {
        registroTemporadasRepository.removeRegistroTemporadas(id);
    }

    public void atualizarRegistroTemporadas(int id, RegistroTemporadasModel registroTemporadasModel) {
        validar(registroTemporadasModel);
        registroTemporadasRepository.updateRegistroTemporadas(id, registroTemporadasModel);
    }

    private RegistroTemporadas validar (RegistroTemporadasModel registroTemporadasModel){
        RegistroTemporadas registroTemporadasEntidade = new RegistroTemporadas(
                registroTemporadasModel.getData(),
                registroTemporadasModel.getIdTemporada(),
                registroTemporadasModel.getIdTime()
        );
        if (!registroTemporadasEntidade.validarRegistroTemporadas()) {
            throw new IllegalArgumentException("Validação do registroTemporadas falhou: " + registroTemporadasEntidade.getErrosValidacao());
        }

        return registroTemporadasEntidade;
    }

}
