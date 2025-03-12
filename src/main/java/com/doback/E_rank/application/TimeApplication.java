package com.doback.E_rank.application;

import com.doback.E_rank.entity.Time;
import com.doback.E_rank.facade.TimeFacade;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeApplication {

    private final TimeFacade timeFacade;

    public TimeApplication(TimeFacade timeFacade) {
        this.timeFacade = timeFacade;
    }

    public List<Time> obterTodosTimes() {
        return timeFacade.listarTimes();
    }

    public Optional<Time> obterTimePorId(Long id) {
        return timeFacade.buscarTimePorId(id);
    }

    public Time criarTime(Time time) {
        return timeFacade.salvarTime(time);
    }

    public void excluirTime(Long id) {
        timeFacade.excluirTime(id);
    }
}
