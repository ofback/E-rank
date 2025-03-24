package com.doback.E_rank.controller;

import com.doback.E_rank.entity.RegistroTemporadas;
import com.doback.E_rank.facade.RegistroTemporadasFacade;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registro-temporadas")
public class RegistroTemporadasController {

    private final RegistroTemporadasFacade registroTemporadasFacade;

    public RegistroTemporadasController(RegistroTemporadasFacade registroTemporadasFacade) {
        this.registroTemporadasFacade = registroTemporadasFacade;
    }

    @GetMapping
    public List<RegistroTemporadas> listarRegistroTemporadas() {
        return registroTemporadasFacade.listarRegistroTemporadas();
    }

    @GetMapping("/{id}")
    public RegistroTemporadas obterRegistroTemporadasPorId(@PathVariable int id) {
        return registroTemporadasFacade.buscarRegistroTemporadasPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarRegistroTemporadas(@RequestBody RegistroTemporadas registroTemporadas) {
        registroTemporadasFacade.salvarRegistroTemporadas(registroTemporadas);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirRegistroTemporadas(@PathVariable int id) {
        registroTemporadasFacade.excluirRegistroTemporadas(id);
    }

}
