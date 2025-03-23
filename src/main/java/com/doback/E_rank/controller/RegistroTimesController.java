package com.doback.E_rank.controller;
import com.doback.E_rank.entity.RegistroTimes;
import com.doback.E_rank.facade.RegistroTimesFacade;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/times")
public class RegistroTimesController {

    private final RegistroTimesController registroTimesFacade;

    public RegistroTimesController(RegistroTimesController registroTimesFacade) {
        this.registroTimesFacade = registroTimesFacade;
    }


    @GetMapping
    public List<RegistroTimes> listarRegistroTimes() {
        return registroTimesFacade.listarRegistroTimes();
    }

    @GetMapping("/{id}")
    public RegistroTimes obterRegistroTimesPorId(@PathVariable Long id) {
        return registroTimesFacade.obterRegistroTimesPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarRegistroTimes(@RequestBody RegistroTimesFacade registroTimeFacade) {
        registroTimesFacade.criarRegistroTimes(registroTimeFacade);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirRegistroTimes(@PathVariable Long id) {
        registroTimesFacade.excluirRegistroTimes(id);
    }

}
