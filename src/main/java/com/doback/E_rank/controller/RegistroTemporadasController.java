package com.doback.E_rank.controller;

import com.doback.E_rank.infrastructure.models.RegistroTemporadasModel;
import com.doback.E_rank.facade.RegistroTemporadasFacade;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registroTemporadas")
public class RegistroTemporadasController {

    private final RegistroTemporadasFacade registroTemporadasFacade;

    public RegistroTemporadasController(RegistroTemporadasFacade registroTemporadasFacade) {
        this.registroTemporadasFacade = registroTemporadasFacade;
    }

    @GetMapping
    public List<RegistroTemporadasModel> listarRegistroTemporadas() {
        return registroTemporadasFacade.listarRegistroTemporadas();
    }

    @GetMapping("/{id}")
    public RegistroTemporadasModel obterRegistroTemporadasPorId(@PathVariable int id) {
        return registroTemporadasFacade.buscarRegistroTemporadasPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarRegistroTemporadas(@RequestBody RegistroTemporadasModel registroTemporadasModel) {
        registroTemporadasFacade.salvarRegistroTemporadas(registroTemporadasModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirRegistroTemporadas(@PathVariable int id) {
        registroTemporadasFacade.excluirRegistroTemporadas(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizarRegistroTemporadas(@PathVariable int id, @RequestBody RegistroTemporadasModel registroTemporadasModel) {
        registroTemporadasFacade.atualizarRegistroTemporadas(id, registroTemporadasModel);
    }

}
