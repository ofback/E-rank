package com.doback.E_rank.application;


import com.doback.E_rank.entity.Times;
import com.doback.E_rank.repository.TimesRepository;
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

    public Times obterTimesPorId(long id) {
        return timesRepository.buscarPorId(id);
    }

    public void criarTime(Times times) {
        timesRepository.adicionar(times);
    }

    public void excluirTime(Long id) {
        timesRepository.remover(id);
    }

}
