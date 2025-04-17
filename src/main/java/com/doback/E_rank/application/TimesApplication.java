package com.doback.E_rank.application;
import com.doback.E_rank.models.Times;
import com.doback.E_rank.interfaces.TimesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimesApplication {

    private final TimesRepository timesRepository;

    public TimesApplication(TimesRepository timesRepository) {
        this.timesRepository = timesRepository;
    }

    public List<Times> obterTodosTimes() {
        return timesRepository.buscar();
    }

    public Times obterTimesPorId(int id) {
        return timesRepository.searchByCode(id);
    }

    public void criarTime(Times times) {
        timesRepository.addTimes(times);
    }

    public void excluirTime(int id) {
        timesRepository.removeTimes(id);
    }
    public void atualizarTimes(int id, Times times) {
        timesRepository.updateTimes(id, times);
    }


}
