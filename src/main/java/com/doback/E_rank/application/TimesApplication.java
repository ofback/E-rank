package com.doback.E_rank.application;
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
        return timesRepository.searchByCode(id);
    }

    public void criarTime(TimesModel timesModel) {
        timesRepository.addTimes(timesModel);
    }

    public void excluirTime(int id) {
        timesRepository.removeTimes(id);
    }
    public void atualizarTimes(int id, TimesModel timesModel) {
        timesRepository.updateTimes(id, timesModel);
    }


}
