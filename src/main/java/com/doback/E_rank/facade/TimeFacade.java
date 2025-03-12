package com.doback.E_rank.facade;

import com.doback.E_rank.entity.Time;
import com.doback.E_rank.repository.TimeRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TimeFacade {

    private final TimeRepository timeRepository;

    public TimeFacade(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }

    public List<Time> listarTimes() {
        return timeRepository.findAll();
    }

    public Optional<Time> buscarTimePorId(Long id) {
        return timeRepository.findById(id);
    }

    public Time salvarTime(Time time) {
        return timeRepository.save(time);
    }

    public void excluirTime(Long id) {
        timeRepository.deleteById(id);
    }
}
