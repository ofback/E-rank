package com.doback.E_rank.facade;
import com.doback.E_rank.application.TimesApplication;
import com.doback.E_rank.models.TimesModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TimesFacade {
    private final TimesApplication timesApplication;

    public TimesFacade(TimesApplication timesApplication) {
        this.timesApplication = timesApplication;
    }

    public List<TimesModel> listarTimes() {
        return timesApplication.obterTodosTimes();
    }

    public TimesModel buscarTimesPorId(int id) {
        return timesApplication.obterTimesPorId(id);
    }

    public void salvarTimes(TimesModel timesModel) {
        timesApplication.criarTime(timesModel);
    }

    public void excluirTimes(int id) {
        timesApplication.excluirTime(id);
    }

    public void atualizarTimes(int id, TimesModel timesModel) {
        timesApplication.atualizarTimes(id, timesModel);
    }
}
