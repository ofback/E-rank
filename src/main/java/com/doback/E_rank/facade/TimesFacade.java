package com.doback.E_rank.facade;

import com.doback.E_rank.application.TimesApplication;
import com.doback.E_rank.entity.Times;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TimesFacade {
    private final TimesApplication timesApplication;

    public TimesFacade(TimesApplication timesApplication) {
        this.timesApplication = timesApplication;
    }

    public List<Times> listarTimes() {
        return timesApplication.obterTodosTimes();
    }

    public Times buscarTimesPorId(Long id) {
        return timesApplication.obterTimesPorId(id);
    }

    public void salvarTimes(Times times) {
        timesApplication.criarTime(times);
    }

    public void excluirTimes(Long id) {
        timesApplication.excluirTime(id);
    }
}
