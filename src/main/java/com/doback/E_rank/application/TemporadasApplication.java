package com.doback.E_rank.application;

import com.doback.E_rank.entity.Temporadas;
import com.doback.E_rank.models.TemporadasModel;
import com.doback.E_rank.interfaces.TemporadasRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class TemporadasApplication {

    private final TemporadasRepository temporadaRepository;

    public TemporadasApplication(TemporadasRepository temporadaRepository) {
        this.temporadaRepository = temporadaRepository;
    }

    public List<TemporadasModel> obterTodasTemporadas() {
        return temporadaRepository.buscar();
    }

    public TemporadasModel obterTemporadaPorId(int id) {
        return temporadaRepository.searchByCode(id);
    }

    public void criarTemporada(TemporadasModel temporadasModel) {
        validar(temporadasModel);
        temporadaRepository.addTemporadas(temporadasModel);
    }

    public void excluirTemporada(int id) {
        temporadaRepository.removeTemporadas(id);
    }

    public void atualizarTemporadas(int id, TemporadasModel temporadasModel) {
        validar(temporadasModel);
        temporadaRepository.updateTemporadas(id, temporadasModel);
    }

    private void validar(TemporadasModel temporadasModel) {
        Date inicio = temporadasModel.getData_inicio();
        Date fim = temporadasModel.getData_fim();

        LocalDate dataInicio = inicio.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate dataFim = fim.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        Temporadas temporada = new Temporadas(
                temporadasModel.getNome(),
                temporadasModel.getDescricao(),
                dataInicio,
                dataFim
        );

        if (!temporada.validarTemporada()) {
            throw new IllegalArgumentException("Erro ao validar temporada: \n" + temporada.getErrosValidacao());
        }
    }
}
