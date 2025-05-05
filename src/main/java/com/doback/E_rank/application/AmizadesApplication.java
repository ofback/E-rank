package com.doback.E_rank.application;
import com.doback.E_rank.entity.Amizades;
import com.doback.E_rank.models.AmizadesModel;
import com.doback.E_rank.interfaces.AmizadesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmizadesApplication {

    private final AmizadesRepository amizadeRepository;

    public AmizadesApplication(AmizadesRepository amizadeRepository) {
        this.amizadeRepository = amizadeRepository;
    }

    public List<AmizadesModel> obterTodasAmizades() {
        return amizadeRepository.buscar();
    }

    public AmizadesModel obterAmizadePorId(int id) {
        return amizadeRepository.searchByCode(id);
    }

    public void criarAmizade(AmizadesModel amizadesModel) {
        validar(amizadesModel);
        amizadeRepository.addAmizades(amizadesModel);
    }

    public void excluirAmizade(int id) {
        amizadeRepository.removeAmizades(id);
    }

    public void atualizarAmizades(int id, AmizadesModel amizadesModel) {
        validar(amizadesModel);
        amizadeRepository.updateAmizades(id, amizadesModel);
    }

    private Amizades validar(AmizadesModel amizadesModel){
        Amizades amizades = new Amizades(
                amizadesModel.getIdUsuario1(),
                amizadesModel.getIdUsuario2(),
                amizadesModel.getStatus(),
                amizadesModel.getDataSolicitacao()
        );

        if(!amizades.validarAmizades()){
            throw new IllegalArgumentException("Validação da amizade falhou: " + amizades.getErrosValidacao());
        }

        return amizades;
    }
}
