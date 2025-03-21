package com.doback.E_rank.application;
import com.doback.E_rank.entity.Amizades;
import com.doback.E_rank.repository.AmizadesRepository;
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

    public Amizades obterAmizadePorId(long id) {
        return amizadeRepository.buscarPorId(id);
    }

    public void criarAmizade(Amizades amizade) {
        amizadeRepository.adicionar(amizade);
    }

    public void excluirAmizade(Long id) {
        amizadeRepository.remover(id);
    }

    public void atualizarAmizades(Long id, Amizades amizades) {
        amizadeRepository.atualizar(id, amizades);
    }


}
