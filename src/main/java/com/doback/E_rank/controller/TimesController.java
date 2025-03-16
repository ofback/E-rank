package com.doback.E_rank.controller;

import com.doback.E_rank.entity.Times;
import com.doback.E_rank.facade.TimesFacade;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/times")
public class TimesController {

    private final TimesFacade timesFacade;

    public TimesController(TimesFacade timesFacade) {
            this.timesFacade = timesFacade;
        }

    @GetMapping
    public List<Times> listarTimes() {
            return timesFacade.listarTimes();
        }

    @GetMapping("/{id}")
    public Times obterTimes(@PathVariable Long id) {
            return timesFacade.buscarTimesPorId(id);
        }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarTimes(@RequestBody Times times) {
            timesFacade.salvarTimes(times);
        }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirTimes(@PathVariable Long id) {
        timesFacade.excluirTimes(id);
    }

}
