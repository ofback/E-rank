package com.doback.E_rank.application;

import com.doback.E_rank.entity.Times;
import com.doback.E_rank.models.TimesModel;
import com.doback.E_rank.interfaces.TimesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimesApplication {

    private final TimesRepository timesRepository;

    public TimesApplication(TimesRepository timesRepository) {
        this.timesRepository = timesRepository;
    }


    public List<TimesModel> obterTodosTimes() {
        return timesRepository.buscar();
    }


    public TimesModel obterTimesPorId(int id) {
        TimesModel timesModel = timesRepository.searchByCode(id);
        if (timesModel == null) {
            throw new IllegalArgumentException("Time não encontrado.");
        }
        return timesModel;
    }


    public void criarTime(TimesModel timesModel) {
        Times timeEntidade = new Times(
                timesModel.getNome(),
                timesModel.getDescricao(),
                timesModel.getSts(),
                timesModel.getIdTemporada(),
                timesModel.getIdUsuario()
        );

        if (!timeEntidade.validarTime()) {
            throw new IllegalArgumentException("Validação do time falhou: " + timeEntidade.getErrosValidacao());
        }

        timesRepository.addTimes(timesModel);
    }


    public void atualizarTimes(int id, TimesModel timesModel) {
        Times timeEntidade = new Times(
                timesModel.getNome(),
                timesModel.getDescricao(),
                timesModel.getSts(),
                timesModel.getIdTemporada(),
                timesModel.getIdUsuario()
        );

        if (!timeEntidade.validarTime()) {
            throw new IllegalArgumentException("Validação do time falhou: " + timeEntidade.getErrosValidacao());
        }

        timesRepository.updateTimes(id, timesModel);
    }


    public void excluirTime(int id) {
        TimesModel timesModel = obterTimesPorId(id);
        timesRepository.removeTimes(timesModel.getId());
    }


}
