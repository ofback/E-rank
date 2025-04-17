package com.doback.E_rank.controller;

import com.doback.E_rank.models.RegistroTimes;
import com.doback.E_rank.facade.RegistroTimesFacade;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registroTimes")
public class RegistroTimesController {

    private final RegistroTimesFacade registroTimesFacade;

    public RegistroTimesController(RegistroTimesFacade registroTimesFacade) {
        this.registroTimesFacade = registroTimesFacade;
    }

    @GetMapping
    public List<RegistroTimes> listarRegistroTimes() {
        return registroTimesFacade.listarRegistroTimes();
    }

    @GetMapping("/{id}")
    public RegistroTimes obterRegistroTimesPorId(@PathVariable int id) {
        return registroTimesFacade.buscarRegistroTimesPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarRegistroTimes(@RequestBody RegistroTimes registroTimes) {
        registroTimesFacade.salvarRegistroTimes(registroTimes);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirRegistroTimes(@PathVariable int id) {
        registroTimesFacade.excluirRegistroTimes(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizarRegistroTimes(@PathVariable int id, @RequestBody RegistroTimes registroTimes) {
        registroTimesFacade.atualizarRegistroTimes(id, registroTimes);
    }
}
