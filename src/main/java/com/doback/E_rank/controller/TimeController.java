package com.doback.E_rank.controller;

import com.doback.E_rank.entity.Time;
import com.doback.E_rank.application.TimeApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/times")
public class TimeController {

    private final TimeApplication timeApplication;

    public TimeController(TimeApplication timeApplication) {
        this.timeApplication = timeApplication;
    }

    @GetMapping
    public List<Time> listarTimes() {
        return timeApplication.obterTodosTimes();
    }

    @GetMapping("/{id}")
    public Optional<Time> obterTime(@PathVariable Long id) {
        return timeApplication.obterTimePorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Time criarTime(@RequestBody Time time) {
        return timeApplication.criarTime(time);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirTime(@PathVariable Long id) {
        timeApplication.excluirTime(id);
    }
}
