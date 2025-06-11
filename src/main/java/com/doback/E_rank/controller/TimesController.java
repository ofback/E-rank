package com.doback.E_rank.controller;
import com.doback.E_rank.infrastructure.models.TimesModel;
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
    public List<TimesModel> listarTimes() {
            return timesFacade.listarTimes();
        }

    @GetMapping("/{id}")
    public TimesModel obterTimes(@PathVariable int id) {
            return timesFacade.buscarTimesPorId(id);
        }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarTimes(@RequestBody TimesModel timesModel) {
            timesFacade.salvarTimes(timesModel);
        }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirTimes(@PathVariable int id) {
        timesFacade.excluirTimes(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizarTimes(@PathVariable int id,@RequestBody TimesModel timesModel){
        timesFacade.atualizarTimes(id, timesModel);
    }
}
