package com.doback.E_rank.controller;

import com.doback.E_rank.entity.Amizade;
import com.doback.E_rank.facade.AmizadeFacade;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/amizades")
public class AmizadeController {

    private final AmizadeFacade amizadeFacade;

    public AmizadeController(AmizadeFacade amizadeFacade) {
        this.amizadeFacade = amizadeFacade;
    }

    @GetMapping
    public List<Amizade> listarAmizades() {
        return amizadeFacade.listarAmizades();
    }

    @GetMapping("/{id}")
    public Amizade obterAmizade(@PathVariable Long id) {
        return amizadeFacade.buscarAmizadePorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAmizade(@RequestBody Amizade amizade) {
        amizadeFacade.salvarAmizade(amizade);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirAmizade(@PathVariable Long id) {
        amizadeFacade.excluirAmizade(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirAmizade(@PathVariable Long id) {
      // implementar!!!!
    }
}
