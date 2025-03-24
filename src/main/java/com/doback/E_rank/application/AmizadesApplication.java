package com.doback.E_rank.application;
import com.doback.E_rank.entity.Amizades;
import com.doback.E_rank.interfaces.AmizadesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmizadesApplication {

    private final AmizadesRepository amizadeRepository;

    public AmizadesApplication(AmizadesRepository amizadeRepository) {
        this.amizadeRepository = amizadeRepository;
    }

    public List<Amizades> obterTodasAmizades() {
        return amizadeRepository.buscar();
    }

    public Amizades obterAmizadePorId(int id) {
        return amizadeRepository.searchByCode(id);
    }

    public void criarAmizade(Amizades amizade) {
        amizadeRepository.addAmizades(amizade);
    }

    public void excluirAmizade(int id) {
        amizadeRepository.removeAmizades(id);
    }

    public void atualizarAmizades(int id, Amizades amizades) {
        amizadeRepository.updateAmizades(id, amizades);
    }


}
