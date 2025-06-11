package com.doback.E_rank.controller;

import com.doback.E_rank.infrastructure.models.RegistroTimesModel;
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
    public List<RegistroTimesModel> listarRegistroTimes() {
        return registroTimesFacade.listarRegistroTimes();
    }

    @GetMapping("/{id}")
    public RegistroTimesModel obterRegistroTimesPorId(@PathVariable int id) {
        return registroTimesFacade.buscarRegistroTimesPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarRegistroTimes(@RequestBody RegistroTimesModel registroTimesModel) {
        registroTimesFacade.salvarRegistroTimes(registroTimesModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirRegistroTimes(@PathVariable int id) {
        registroTimesFacade.excluirRegistroTimes(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizarRegistroTimes(@PathVariable int id, @RequestBody RegistroTimesModel registroTimesModel) {
        registroTimesFacade.atualizarRegistroTimes(id, registroTimesModel);
    }
}
